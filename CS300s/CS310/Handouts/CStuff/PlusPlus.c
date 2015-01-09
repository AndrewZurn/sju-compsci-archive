#include <stdio.h>
#include <stdlib.h>

/* This is a demonstration program meant
 * to show how the ++ operator and the
 * * operator work to access memory in
 * odd ways.
 */
int main(int argc,char ** argv) {
  int * x;
  int i,j;
  x=calloc(5,sizeof(int));
  for(i=0;i<5;i++) {
    x[i]=3*i-1;
  }
  j=5;
  printf("j=%d ",j);
  printf("printing ++j %d  ",++j);
  printf("printing j++ %d  ",j++);
  printf("j=%d\n",j);
  printf("printing *x %d ",*x);
  printf("printing ++*x %d ",++*x);
  printf("printing *++x %d \n",*++x);
  printf("printing *x++ %d ",*x++);
  printf("printing *x %d\n",*x);
}
