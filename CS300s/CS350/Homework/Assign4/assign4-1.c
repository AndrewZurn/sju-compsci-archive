/*
* File: Assign4-1.c
* Assignment 4-1 from page 87 of book
* Author: Andrew Zurn
* Due Date: 10/2/2012
*/

#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <fcntl.h>

int main(int argc, char ** argv){
  int MAX_READ = 64;
  char * buffer;
  ssize_t numRead = 0;
  ssize_t numWritten;
  int fd;

  buffer = (char *) malloc(MAX_READ * sizeof(char));

  if( argc > 1 && strcmp(argv[1], "-a") == 0){  //-a specified, will append to given file
    numRead = read(0, buffer, MAX_READ);
    if(numRead == -1){
        printf("read1 error!");
        return -1;
      }
    fd = open(argv[2], O_CREAT | O_RDWR | O_APPEND, S_IRUSR | S_IWUSR);
    if(fd == -1){
      printf("open error! \n");
      return -1;
    }
    buffer[numRead] = '\0';
    fprintf(stdout, "%s", buffer);
    numWritten = write(fd, buffer, numRead);
    if(numWritten == -1){
      printf("write error! \n");
      return -1;
    }
    if( (close(fd)) == -1 ){
      printf("close error! \n");
      return -1;
    }
    return 0;
  }

  else{ //will print to STDOUT
      numRead = read(0, buffer, MAX_READ);
      if(numRead == -1){
        printf("read2 error!");
        return -1;
      }
    buffer[numRead] = '\0';
    fprintf(stdout, "%s", buffer);
  }
  return 0;
}
