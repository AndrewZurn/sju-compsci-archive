#include <stdio.h>
#include <stdlib.h>
int main(int argv, char ** args) {
  FILE *fp=fopen(args[1],"r");
  int i, isquared;
  if(fp==NULL) {
	printf("No results.dat file.");
	exit(0);
  }
  while(fscanf(fp,"%d,%d\n",&i,&isquared)!=EOF) {
	printf("i: %d, isquared: %d\n",i,isquared);
  }
  fclose(fp);
  return(0);
}
