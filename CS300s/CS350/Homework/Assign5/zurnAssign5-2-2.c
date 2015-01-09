/*
* File: zurnAssign5-1-2.c (opp2)
* Author: Andrew Zurn
* Due Date: 10/12/12
*/

#include <sys/types.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int returnCount=0;
char * procName;


static void catch_sig(int sig) {
  if (sig == SIGUSR1) {
		printf("Signal was caught!");
    returnCount++;
  }
  else if(sig == SIGUSR2){
    printf("VICTORY! The game was won by %s ", procName);
    exit(EXIT_SUCCESS);
  }
}

int main(int argc, char *argv[]){
  pid_t pid = getpid();
  int buf;
  printf("PID:  %d\n", pid);
  printf("Please enter the other program's pid: ");
  scanf("%d", &buf);
  pid_t target = (pid_t) buf;
  int randomInt;

  procName = (char*)argv[0];

	sigset_t blockSet;

  sigemptyset(&blockSet);
  sigaddset(&blockSet, SIGUSR1);

	if(sigprocmask(SIG_BLOCK, &blockSet, NULL) == -1){
		printf("Block SIGUSR1 failed!");
		exit(-1);
	}

  for(;;){
    pause();
    if (signal(SIGUSR1, catch_sig) == SIG_ERR) {
    		printf("signal failed ");
    		exit(EXIT_FAILURE);
  	}
    randomInt = random();
    if((randomInt%2) == 0){
		  printf("Signal returned by %s ", argv[0]);
      if (kill(target, SIGUSR1) == -1) {
    		printf("signal not sent, terminating");
    		exit(EXIT_FAILURE);
  		}
    }
    else if((randomInt%2) == 1){ //drop signal
      if (kill(target, SIGUSR2) == -1) {
    			printf("signal not sent, terminating");
    			exit(EXIT_FAILURE);
  			}
      printf("Signal dropped by %s\n", argv[0]);
		  printf("Their score was %d\n", returnCount);
      break;
    }
  }
  return (EXIT_SUCCESS);
}
