#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>

int nArgs;
char ** parseLine(char * input) {
  char ** tresult=malloc(20*sizeof(char *));
  int i;
  for(i=0;i<20;i++) {
    tresult[i]=malloc(80);
    tresult[i][0]=0;
  }
  nArgs=0;
  i=0;
  int charPos=0;
  while(input[i]!='\n') {
    if((input[i]==' ') || (input[i]=='\t')) {
      i++;
      while((input[i]==' ') || (input[i]=='\t')) {
	i++;
      }
      tresult[nArgs][charPos]=0;
      nArgs++;
      charPos=0;
    }
    if(input[i]!='\n') {
      tresult[nArgs][charPos]=input[i];
      charPos++;
      i++;
    }
    else {
      tresult[nArgs][charPos]=0;
    }
  }
  tresult[nArgs][charPos]=0;
  nArgs++;
  tresult[nArgs]=NULL;
  return tresult;
}
