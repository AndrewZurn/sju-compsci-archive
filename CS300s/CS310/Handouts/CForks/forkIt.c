#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
int main() {
  int n=20;
  int pid=0;
  printf("main process has id %d\n",getpid());
  while(n>0) {
    int pid=fork();
    if(pid==0) {
      printf("pid %d %d %d \n",getpid(),pid,n);
      exit(0);
    }
    n--;
  }
  exit(0);
}
