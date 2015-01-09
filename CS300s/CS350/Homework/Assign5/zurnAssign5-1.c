/*
* File: zurnAssign5-1.c
* Author: Andrew Zurn
* Due Date: 10/12/12
*/

#include <string.h>
#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include <fcntl.h>
#include <dirent.h>
#include <sys/types.h>
#include "errno.h"

int main(int argc, char *argv[]){
  DIR *dir;
  struct dirent *rddir;
  int errno;

  dir = opendir(argv[1]);
  if(dir == NULL){
    fprintf(stderr, "Directory could not be opened!\n");
    return -1;
  }

  for(;;){
    rddir = readdir(dir);
    errno = 0;
    if(rddir == NULL){
      break;
    }
    if(errno != 0){
      fprintf(stderr, "There was a problem reading the directory\n");
      return -1;
    }
    printf("Inode #: %d ", rddir->d_ino);
    printf(" Filename: %s \n", rddir->d_name);
  }
  
  if(closedir(dir) == -1){
    fprintf(stderr, "Directory could not be closed!\n");
    return -1;
  }
  return 0;
}
