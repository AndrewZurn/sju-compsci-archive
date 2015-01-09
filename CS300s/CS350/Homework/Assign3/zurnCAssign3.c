/*
* File: zurnCAssign3.c
* Author: Andrew Zurn
* Referenced Michael Kerrisk's work from chapter 4 of his book.
* Due Date: 09/24/2012
*/

#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

int main(int argc, char ** argv){
  int inputFd;
  ssize_t numRead;
  int BUF_SIZE = 89;
  char buf[BUF_SIZE];

  inputFd = open("/net/home/f10/awzurn/zurnCAssignTxt.txt", O_RDONLY);
  if(inputFd == -1){
    printf("There was an error in opening the file. System will exit!");
    return -1;
  }
  numRead = read(inputFd, buf, BUF_SIZE);
  if(numRead <= BUF_SIZE){
    fprintf(stdout, "The contents of the file: \n %s \n", buf);
    return 0;
  }
  else{
    fprintf(stderr, "There was an error in printing the file to the command line. System will exit!");
    return -1;
  }
}
