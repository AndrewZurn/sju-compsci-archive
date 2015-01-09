/*
* Author: Andrew Zurn
* Due Date: Wednesday, November 28th 2012
* Description: This is the server-side program that
* waits for players to enter a game, and begins the game
* after 60 seconds has elapsed.
*/

/*
*Notes: server to send info to clientFIFOs, clients to send info to serverFIFO
*/

#include <sys/stat.h>
#include <sys/types.h>
#include <fcntl.h>
#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include <ctype.h>
#include <errno.h>

int random_range(int min, int max){
  int dif = max-min;
  return (int) (((double)(dif+1)/RAND_MAX) * rand() + min);
}

int main(){
  int rand = 0, start = 0, client1_score, client2_score;
  int server_fd, client_fd_1, client_fd_2, num_read;
  const char * server_fifo = "/tmp/awzurn_server_FIFO";
  const char * client_fifo_1 = "/tmp/awzurn_client_FIFO_1";
  const char * client_fifo_2 = "/tmp/awzurn_client_FIFO_2";
  char * buffer, * buffer2;
  buffer = (char *) malloc(55 * sizeof(char));
  buffer2 = (char *) malloc(55 * sizeof(char));
  time_t client1_time_start, client1_time_end, client1_final, client2_time_start, client2_time_end, client2_final;
  umask(0);
  if(mkfifo(server_fifo, S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP | S_IROTH | S_IWOTH) == -1 && errno != EEXIST ){
    perror("server_fifo creation error, exiting\n");
    exit(EXIT_FAILURE);
  }
  if(mkfifo(client_fifo_1, S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP | S_IROTH | S_IWOTH) == -1 && errno != EEXIST ){
    perror("client_fifo_1 creation error, exiting\n");
    exit(EXIT_FAILURE);
  }
  if(mkfifo(client_fifo_2, S_IRUSR | S_IWUSR | S_IRGRP | S_IWGRP | S_IROTH | S_IWOTH) == -1 && errno != EEXIST ){
    perror("client_fifo_2 creation error, exiting\n");
    exit(EXIT_FAILURE);
  }

  printf("attempting to open server fifo...");
  server_fd = open(server_fifo, O_RDONLY );
  if(server_fd == -1){
    perror("server_fd open error, exiting\n");
    exit(EXIT_FAILURE);
  }
  printf(" opened!\n");

  printf("attempting to open client1 fifo...");
  client_fd_1 = open(client_fifo_1, O_WRONLY);
  if(client_fd_1 == -1){
    perror("client_fd_1 open error, exiting\n");
    exit(EXIT_FAILURE);
  }
  printf(" opened!\n");

  printf("attempting to open client2 fifo...");
  client_fd_2 = open(client_fifo_2, O_WRONLY);
  if(client_fd_2 == -1){
    perror("client_fd_2 open error, exiting\n");
    exit(EXIT_FAILURE);
  }
  printf(" opened!\n");

  for(;;){
    if( start == 0 ){
      int rand = random_range(0, 1);
      start = 1;
    }
    if(rand == 0){ //client 1 is pitcher
      if(write(client_fd_1, "0", 2) != 2){
        perror("write error to client1");
      }
      if(write(client_fd_2, "1", 2) != 2){
        perror("write error to client1");
      }
      client1_time_start = time(NULL);
      if((num_read = read(server_fd, buffer, 55)) != 55){ //wait for text line
        perror("read error");
      }
      client1_time_end = time(NULL);
      client1_final = client1_time_end - client1_time_start;
      printf("%s\n", buffer);
      if(write(client_fd_2, buffer, 55) != 55){ //send to other player
        perror("write error");
      }
	  client2_time_start = time(NULL);
      if((num_read = read(server_fd, buffer, 55)) != 55){ //read response
        perror("read error");
      }
      client2_time_end = time(NULL);
      client2_final = client2_time_end - client2_time_start;
      if(strcmp(buffer, "end") == 0){
	printf("Game over, player 1 is victorious!\n");
        break;
      }
    }
    else{ //client 2 is pitcher
      if(write(client_fd_2, "0", 2) != 2){
        perror("write error to client2");
      }
      if(write(client_fd_1, "1", 2) != 2){
        perror("write error to client1");
      }
      client2_time_start = time(NULL);
      if((num_read = read(server_fd, buffer, 55)) != 55){ //wait for line
        perror("read error");
      }
      client2_time_end = time(NULL);
      client2_final = client2_time_end - client2_time_start;
      printf("%s\n", buffer);
      if(write(client_fd_1, buffer, 55) != 55){ //send to other player
        perror("write error");
      }
      client1_time_start = time(NULL);
      if((num_read = read(server_fd, buffer, 55)) != 55){ //read response
        perror("read error");
      }
      client1_time_end = time(NULL);
      client1_final = client1_time_start - client1_time_end;
      if(strcmp(buffer, "end") == 0){
        printf("Game over, player 2 is victorious!\n");
        break;
      }
    }
	
    printf("client1: %d\n", client1_final);
    printf("client2: %d\n", client2_final);
    if(client1_final < client2_final){
      client2_score = client2_score + 10000/client2_final;
      rand = 0;
    }
    else if(client1_final > client2_final){
      client1_score = client1_score + 10000/client1_final;
      rand = 1;
    }
    else{
      rand = random_range(0, 1);
    }
  }
  sprintf(buffer, "%d", client1_final);
  if(write(client_fd_1, buffer, 55) != 55){
    perror("write error");
  }
  if(write(client_fd_2, buffer, 55) != 55){
    perror("write error");
  }
  sprintf(buffer, "%d", client2_final);
  if(write(client_fd_2, buffer, 55) != 55){
    perror("write error");
  }
  if(write(client_fd_1, buffer, 55) != 55){
    perror("write error");
  }
  exit(EXIT_SUCCESS);
}
