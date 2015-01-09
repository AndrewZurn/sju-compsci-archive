#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include "makeargv.c"
#include <signal.h>
  
  static void sigHandler(int sig){
  if(sig == SIGINT){
    return;
  }
}

int main(int argc, char ** args){
  pid_t parentPid = getpid();
  int wasCd = 0;
  for(;;){
    const char * s;
    char inptStr[100];
    char ** argvp;
    pid_t childPid;
    wasCd = 0;
    
    fprintf(stdout, "Please Enter a Command: ");
    
    if(signal(SIGINT, sigHandler) == SIG_ERR){
      printf("signal error, exiting");
      exit(EXIT_FAILURE);
    }
    
    fgets(inptStr, 100, stdin);
    s = inptStr;
    if((makeargv(s," \n", &argvp)) == -1){
      fprintf(stderr, "makeargv error, exiting");
      exit(EXIT_FAILURE);
    }
    
    if((strcmp(argvp[0], "cd")) == 0){
      if((chdir(argvp[1])) != 0){
        printf("change dir error, exiting");
        exit(EXIT_FAILURE);
      }
      wasCd = 1;
    }
    
    if(wasCd != 1){
      childPid = fork();
      if(childPid == -1){
        fprintf(stderr, "fork error, exiting");
        exit(EXIT_FAILURE);
      }
      
      else if(childPid == 0){ //child process
        if((strcmp(argvp[0], "exit")) == 0){
          kill(childPid, SIGKILL);
          kill(parentPid, SIGKILL);
          exit(EXIT_SUCCESS);
        }
        execvp(argvp[0], &argvp[0]);
        exit(EXIT_SUCCESS);
      }
      
      else if(childPid != -1 || childPid != 0){ //parent process
        wait(NULL);
      }
    }
    
  }
  return EXIT_SUCCESS;
}

