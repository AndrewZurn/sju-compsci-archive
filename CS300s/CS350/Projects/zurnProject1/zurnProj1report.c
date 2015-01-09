/*
* Author: Andrew Zurn
* Discr: This is a report generator that will use the zurnProg1.log file to generate a detailed report of the game.
* Due Date: 10/24/12
*/

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <time.h>

int main(int argc, char * argv[]){
  int fd;
  ssize_t numRead = 0;
  char * name[9];
  suseconds_t * best[23];
  suseconds_t * worst[23];
  suseconds_t * average[23];
  char * date[23];
  int end_of_file = 1;
  off_t off_set;
  int i;

  fd = open("zurnProg1.log", O_RDONLY, S_IRUSR | S_IWUSR);
  if(fd == -1){
    fprintf(stderr, "open error, exiting\n");
    exit(EXIT_FAILURE);
  }
  if( (off_set = lseek(fd, 0, SEEK_SET)) == -1){
    fprintf(stderr, "seek error, exiting\n");
    exit(EXIT_FAILURE);
  }
  for(i = 0; i < 2; i++){
    if( (numRead = read(fd, name, 10)) == -1){
      fprintf(stderr, "read error, exiting\n");
      exit(EXIT_FAILURE);
    }
    if( (numRead = read(fd, best, 24)) == -1){
      fprintf(stderr, "read error, exiting\n");
      exit(EXIT_FAILURE);
    }
    if( (numRead = read(fd, worst, 24)) == -1){
      fprintf(stderr, "read error, exiting\n");
      exit(EXIT_FAILURE);
    }
    if( (numRead = read(fd, date, 64)) == -1){
      fprintf(stderr, "read error, exiting\n");
      exit(EXIT_FAILURE);
    }
    printf("User name is %s \n", name);
    printf("Best time was %d \n", best);
    printf("Worst time was %d \n", worst);
    printf("Average time was %d \n", average);
    printf("Last time played was on %s \n\n", date);
  }

  if((close(fd)) == -1){
    fprintf(stderr, "close error, exiting\n");
    exit(EXIT_FAILURE);
  }
  return(EXIT_SUCCESS);
}
