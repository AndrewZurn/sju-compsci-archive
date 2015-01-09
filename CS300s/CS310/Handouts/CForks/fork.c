#include <stdlib.h>
#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
int main(int argv, char ** args) {
  int pid2,pid=getpid();
  pid2=fork();
  if(pid2!=0) {
    printf("main process %d forked process %d\n",pid,pid2);
  } else {
    printf("child process %d was forked\n",getpid());
  }
  exit(0);
}
