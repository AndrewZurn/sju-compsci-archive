/*
* File: zurnAssign5-1-1.c (opp1)
* Author: Andrew Zurn
* Due Date: 10/12/12
* This is the program that asks for the oppenents pid.
*/

#include <sys/types.h>
#include <signal.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>

int returnCount=0;
char * procName;

static void catch_sig(int sig) {
  if (sig == SIGUSR1) {
    returnCount++;
  }
  else if(sig == SIGUSR2){
    printf("VICTORY! The game was won by %s ", procName);
    exit(EXIT_SUCCESS);
  }
}

int whoStarts(){ //return 0 in event SERVER is selected, or 1 if RECEIVER is selected, or -1 on error.
  char buf[10];
  printf("Will this program start as the SERVER or RECEIVER? (Please input one): ");
  scanf("%s", &buf);
  if(buf[0] == 'S'){
    return 0;
  }
  else if(buf[0] == 'R'){
    return 1;
  }
  return -1;
}

int main(int argc, char *argv[]){
  pid_t target = atoi(argv[1]);
  pid_t pid = getpid();
  printf("PID:  %d\n", pid);
  int starts;
  int randomInt;
	procName = (char*)argv[0];
  
  sigset_t blockSet;

  sigemptyset(&blockSet);
  sigaddset(&blockSet, SIGUSR1);

	if(sigprocmask(SIG_BLOCK, &blockSet, NULL) == -1){
		printf("Block SIGUSR1 failed!");
		exit(-1);
	}


  starts = whoStarts();
  if(starts == -1){ //error
    printf("Good going, clown!\n");
    return -1;
  }
  else if(starts == 0){ //SERVER
//		if(sigprocmask(SIG_UNBLOCK, &blockSet, NULL) == -1){
//			printf("Block SIGUSR1 failed!");
//			exit(-1);
//		}
		if (kill(target, SIGUSR1) == -1) {
    	printf("signal not sent, terminating0\n");
    	exit(EXIT_FAILURE);
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
    			printf("signal not sent, terminating1\n");
    			exit(EXIT_FAILURE);
  			}
      }
      else if((randomInt%2) == 1){ //drop signal
        if (kill(target, SIGUSR2) == -1) {
    			printf("signal not sent, terminating2\n");
    			exit(EXIT_FAILURE);
  			}
        printf("Signal dropped by %s ", argv[0]);
        break;
      }
    }
  }
  else if(starts == 1){ //RECEIVER
		returnCount--;
		if(sigprocmask(SIG_UNBLOCK, &blockSet, NULL) == -1){
			printf("Block SIGUSR1 failed!");
			exit(-1);
		}
		if (kill(target, SIGUSR1) == -1) {
    	printf("signal not sent, terminating3\n");
    	exit(EXIT_FAILURE);
  	}
    for(;;){
      pause();
      if (signal(SIGUSR1, catch_sig) == SIG_ERR) {
    		perror("signal failed ");
    		exit(EXIT_FAILURE);
  		}
      randomInt = random();
      if((randomInt%2) == 0){
        printf("Signal returned by %s ", argv[0]);
				if (kill(target, SIGUSR1) == -1) {
    			printf("signal not sent, terminating4\n");
    			exit(EXIT_FAILURE);
  			}
      }
      else if((randomInt%2) == 1){ //drop signal
        if (kill(target, SIGUSR2) == -1) {
    			printf("signal not sent, terminating5\n");
    			exit(EXIT_FAILURE);
  			}
        printf("Signal dropped by %s\n", argv[0]);
				printf("Their score was %d\n", returnCount);
        break;
      }
    }
  }
}

