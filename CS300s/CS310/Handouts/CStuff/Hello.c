#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int GCD(int i, int j) {
  if(i==0) return j;
  else return GCD(j%i,i);
}
int main(int argc,char ** argv) {
  int i,j;
  char s[15];
  char * t;
  t=malloc(15);
  strcpy(s,"Hello");
  strcpy(t,"World");
  printf("%s %s\n",s,t);
  double pi=3.1415926536;
  printf("Hello, World!\n");
  printf("Enter i and j:");
  scanf("%d%d",&i,&j);
  printf("Here are i, j, and GCD(i,j): %5d %5d %5d\n",i,j,GCD(i,j));
  int k;
  for(k=0;k<argc;k++) {
    printf("%s ",argv[k]);
  }
  printf("\n");
  printf("pi = %7.3f\n",pi);
}
