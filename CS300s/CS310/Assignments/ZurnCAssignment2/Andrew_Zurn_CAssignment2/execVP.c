#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>

int main(int argc, char ** args){
  int pid;
  int n = 1;
  while(n>0){
  	char ** x;
  	char y[100];
	printf("Please Enter a Valid Command: ");
	fgets(y, 100, stdin);
	x=malloc(20*sizeof(y));
	x=parseLine(y);
	pid=fork();
	if(pid==0){
	  execvp(x[0],x);
	  int i;
	  for(i=0;i<200;i++) {
    	    free(x[i]);
  	  }
  	  free(x);
	}
	else{
	  wait(NULL);
	}
        n++;
    } 
}
