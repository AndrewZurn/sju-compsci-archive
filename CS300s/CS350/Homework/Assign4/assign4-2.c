/*
* File: Assign4-2.c
* Assignment 5-2 from page 110 of book
* Author: Andrew Zurn
* Due Date: 10/2/2012
*/

#include <unistd.h>
#include <stdio.h>
#include <fcntl.h>

int main(int argc, char ** argv){
  int inputFd;
  off_t offSet = 0;
  ssize_t numWritten;
  char * buf;
  buf = "Will this work? Maybe? Maybe not?";

  inputFd = open("/net/home/f10/awzurn/Dropbox/School/SJU/CompSci/CS350/Homework/Assign4/assign4-2txt.txt", O_WRONLY | O_APPEND);
  if(inputFd == -1){
    printf("open error! \n");
    return -1;
  }

  offSet = lseek(inputFd, offSet, SEEK_SET);
  if(offSet == -1){
    printf("seek error! \n");
    return -1;
  }

  numWritten = write(inputFd, buf, 33);
  if(numWritten == -1){
    printf("write error! \n");
    return -1;
  }

  if( (close(inputFd)) == -1 ){
    printf("close error! \n");
    return -1;
  }
  return 0;
}
