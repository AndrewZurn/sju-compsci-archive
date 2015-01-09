/*
 * Author: Andrew Zurn
 * Discr: This will be a game that looks for user interaction to test response skills.
 * Due Date: 10/24/12
 */

#include <sys/types.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <time.h>
#include <sys/time.h>
#include <fcntl.h>
#include <sys/stat.h>
  
static int FIXED_RESPONSE = 20;
suseconds_t best, worst, average;
suseconds_t *best_pointer, *worst_pointer, *average_pointer;
int timer = 1;
struct timeval tv;
struct itimerval itv;
suseconds_t response_time_array[20];
suseconds_t start_time;
int array_index=0;

static void catch_sig(int sig){
  int caught = -1;
  suseconds_t response_time;
  if(sig == SIGINT){
    //system return current time, add to array to be processed at the end of the game.
    if(getitimer(ITIMER_REAL, &itv) == -1){
      printf("getitimer error, exiting");
      exit(EXIT_FAILURE);
    }
    response_time = (start_time - itv.it_value.tv_usec);
    printf("\nYour response time was: %d microseconds\n", response_time);
    response_time_array[array_index] = response_time;
    array_index++;
    caught = 0;
    return;
  }
  else if(sig == SIGVTALRM  || sig == SIGALRM){
    if(caught){
      return;
    }
    else if(!caught){
      printf("You did not stop the timer in time!");
      time_t response_time = 50;
      response_time_array[array_index] = response_time;
      array_index++;
      return;
    }
  }
  else{
    fprintf(stderr, "Unknown signal error: %d, exiting \n", sig);
    exit(EXIT_FAILURE);
  }
}

int process_times(){
  //go through each time processed, setting the first to the worst, second if better than first to best, and checking both for each new time.  Add up all times, and divide by FIXED_RESPONSE.
  int i;
  worst = response_time_array[0];
  best = response_time_array[0];
  for(i = 1; i<FIXED_RESPONSE; i++){
    if( response_time_array[i] > worst){
      worst = response_time_array[i];
    }
    else if( response_time_array[i] < best){
      best = response_time_array[i];
    }
    average = average + response_time_array[i];
  }
  average = average / FIXED_RESPONSE;
  best_pointer = &best;
  worst_pointer = &worst;
  average_pointer = &average;
  return 0;
}

int main(int argc, char * argv[]){
  int rand_int;
  itv.it_value.tv_sec = 300;
  char * user_name[8];
  printf("Welcome to the Andrew Zurn's Response Timing Game!\n");
  printf("Please enter a user name 8 characters in length!\n"); //must be 8 characters
  scanf("%s", user_name);
  user_name[8] = '\0';
  printf("%s, get ready to play!\n", user_name);
  
  int i;
  for(i=0;i<FIXED_RESPONSE;i++){
    printf("Trial: %d of %d \n", i+1, FIXED_RESPONSE);
    rand_int = random();
    if(rand_int >= 0 && rand_int <= 715827881){//timer at 1 secs
      //sleep 1 second, then start timer, signal handler will stop timer and store for processing.
      sleep(1);
      printf("Timer Elapsed! Press CONTROL+C!");
      if ((setitimer(ITIMER_REAL, &itv, 0)) == -1){
        printf("timer error, exiting\n");
        exit(EXIT_FAILURE);
      }
      start_time = itv.it_value.tv_usec;
      if(signal(SIGINT, catch_sig)==SIG_ERR){
        printf("Signal send error, exiting\n");
        exit(EXIT_FAILURE);
      }
      pause();
    }
    else if(rand_int >= 715827882 && rand_int <= 1431655762){//timer at 2 secs
      //sleep 2 seconds, then start timer, signal handler will stop timer and store for processing.
      sleep(2);
      printf("Timer Elapsed! Press CONTROL+C!\n");
      if ((setitimer(ITIMER_REAL, &itv, 0)) == -1){
        printf("timer error, exiting\n");
        exit(EXIT_FAILURE);
      }
      start_time = itv.it_value.tv_sec;
      if(signal(SIGINT, catch_sig)==SIG_ERR){
        printf("Signal send error, exiting\n");
        exit(EXIT_FAILURE);
      }
      pause();
    }
    else if(rand_int >= 1431655763 && rand_int <= RAND_MAX){//timer at 3 secs
      //sleep 4 seconds, then start timer, signal handler will stop timer and store for processing.
      sleep(3);
      printf("Timer Elapsed! Press CONTROL+C!\n");
      if ((setitimer(ITIMER_REAL, &itv, 0)) == -1){
        printf("timer error, exiting\n");
        exit(EXIT_FAILURE);
      }
      start_time = itv.it_value.tv_sec;
      if(signal(SIGINT, catch_sig)==SIG_ERR){
        printf("Signal send error, exiting\n");
        exit(EXIT_FAILURE);
      }
      pause();
    }
  }
  
  process_times();
  printf("Your best time was: %d microseconds\n", best);
  printf("Your worst time was: %d microseconds\n", worst);
  printf("Your average time was: %d microseconds\n", average);
  
  char save_option[1]; //Y or N for save option
  printf("Would you like to save your scores: Y or N\n");
  printf("WARNING: Saving your game data will overwrite any saved data you may have!\n");
  scanf("%s", save_option);
  if(save_option[0] == 'Y'){
    //save game data - FIXED LENGTH of 60 bits in file
    int fd = open("zurnProg1.log", O_CREAT | O_RDWR, S_IRUSR | S_IWUSR);
    ssize_t numRead = 0;
    char * user_name_buffer[8];
    int user_read = 9;
    int searching_for_user = 0;
    off_t off_set = 52;
    ssize_t num_written;
    
    if(fd == -1){
      fprintf(stderr, "Open .log file error, exiting\n");
      exit(EXIT_FAILURE);
    }
    while(searching_for_user){
      if((numRead = read(fd, user_name_buffer, user_read)) != 8){
        fprintf(stderr, "user_name read error, exiting\n");
        exit(EXIT_FAILURE);
      }
      if((strcmp(*user_name_buffer, *user_name)) == 0){
        searching_for_user = 1; //user name found, exit while
      }
      off_set = lseek(fd, off_set, SEEK_SET);
      if(off_set == -1){
        //fprintf(stderr, "seek error, exiting\n");
        break; //end-of-file
      }
    }
    if(searching_for_user == 0){ //user never found, start new record
      //find how to make file append only and append record 
      if((close(fd)) == -1){
        fprintf(stderr, "close error, exiting\n");
        exit(EXIT_FAILURE);
      }
      int fd = open("zurnProg1.log", O_CREAT | O_RDWR | O_APPEND, S_IRUSR | S_IWUSR); //will only add to end of file
      if(fd == -1){
        fprintf(stderr, "Open .log file error, exiting\n");
        exit(EXIT_FAILURE);
      }
      num_written = write(fd, user_name, 8);
      num_written = write(fd, best_pointer, 8);
      num_written = write(fd, worst_pointer, 8);
      num_written = write(fd, average_pointer, 8);
      time_t my_time = time(NULL);
      char * current_date = ctime(&my_time);
      num_written = write(fd, current_date, 24);
      if((close(fd)) == -1){
        fprintf(stderr, "close error, exiting\n");
        exit(EXIT_FAILURE);
      }
      printf("SAVE SUCCESSFULL! GAME OVER! Please play again!\n");
      return(EXIT_SUCCESS);
    }
    else if(searching_for_user == 1){ //user found, alter record
      off_set = lseek(fd, 1, SEEK_SET);
      //write best
      num_written = write(fd, best_pointer, 8);
      //write worst
      num_written = write(fd, worst_pointer, 8);;
      off_set = lseek(fd, 1, SEEK_SET);
      //write average
      num_written = write(fd, average_pointer, 8);
      //write date
      time_t my_time = time(NULL);
      char * current_date = ctime(&my_time);
      num_written = write(fd, current_date, 24);
      printf("SAVE SUCCESSFULL! GAME OVER! Please play again!\n");
      if((close(fd)) == -1){
        fprintf(stderr, "close error, exiting\n");
        exit(EXIT_FAILURE);
      }
      return(EXIT_SUCCESS);
    }
    return(EXIT_FAILURE);
  }
  else if(save_option[0] == 'N'){
    //do not save data, effectively end the game
    printf("GAME OVER! Please play again!\n");
    return(EXIT_SUCCESS);
  }
  else{
    fprintf(stderr, "save_option selection error: %s \n", save_option);
    exit(EXIT_FAILURE);
  }
  return(EXIT_FAILURE);
}
