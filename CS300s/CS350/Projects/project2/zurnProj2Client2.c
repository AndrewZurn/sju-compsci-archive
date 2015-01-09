/*
* Author: Andrew Zurn
* Due Date: Wednesday, November 28th 2012
* Description: This is the client-side program for the Text Tumbler
* game to be implemented using FIFOs.
*/

/*
*Notes: server to send info to clientFIFOs, clients to send info to serverFIFO
*
*/

#include <sys/stat.h>
#include <sys/types.h>
#include <fcntl.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <ctype.h>
#include <errno.h>

int main(){
  const char * server_fifo = "/tmp/awzurn_server_FIFO";
  const char * my_fifo = "/tmp/awzurn_client_FIFO_2";
  int server_fd, my_fd, num_read;
  char * buffer, * buffer2;
  buffer = (char *) malloc(55 * sizeof(char));
  buffer2 = (char *) malloc(55 * sizeof(char));

  printf("Welcome to the Text Tumbler game, player 2.\nPlease wait for a response from the server.\n");

  server_fd = open(server_fifo, O_WRONLY);
  if(server_fd == -1){
    printf("server_fd open error, exiting\n");
    exit(EXIT_FAILURE);
  }
  printf("server fifo open, attempting to open client fifo...");

  my_fd = open(my_fifo, O_RDONLY);
  if(my_fd == -1){
    printf("my_fd open error, exiting\n");
    exit(EXIT_FAILURE);
  }
  printf(" opened!\n");
  printf("\n\n\n*********************************************\n");
  printf("*Welcome to the Text Tumble game, player 2.*\n*Please wait for a response from the server.*\n");
  printf("*********************************************\n");

  for(;;){
    if( num_read = read(my_fd, buffer, 2) != 2){
      perror("read error");
    }
    if( (atoi(buffer)) == 0 ){ //pitcher
      sleep(3);
      printf("You are the pitcher! Please input a Text Tumble to throw to the other player!\n");
      fgets(buffer, 55, stdin);
      if(write(server_fd, buffer, 55) != 55){
        perror("write error");
      }
    }
    else{ // catcher
      printf("You are the catcher, please wait for you Text Tumble to be thrown!\n");
      read(my_fd, buffer, 55);
      printf("Here is your Text Tumble! Be Ready!\n");
      sleep(3);
      printf("%s\n", buffer);
      fgets(buffer2, 55, stdin);
      if(strcmp(buffer, buffer2) != 0){
        printf("Sorry, you entered the incorrect text! Game Over!\n");
        if(write(server_fd, "end", 55) != 55){
          perror("write error");
        }
        if(read(my_fd, buffer, 55) != 55){
          perror("read error");
        }
        printf("Your Text Tumble score was: %s\n", buffer);
        int my_score, opp_score;
        my_score = atoi(buffer);
        if(read(my_fd, buffer, 55) != 55){
          perror("read error");
        }
        printf("Your Opponent's Text Tumble score was: %s\n", buffer);
        opp_score = atoi(buffer);
        if(opp_score > my_score){
          printf("You lose!\n");
        }
        else if(my_score > opp_score){
          printf("You win!\n");
        }
        else{
          printf("Bad scores!");
        }
        exit(EXIT_SUCCESS);
      }
      if(write(server_fd, buffer2, 55) != 55){
        perror("write error");
      }
    }
  }
  exit(EXIT_SUCCESS);
}
