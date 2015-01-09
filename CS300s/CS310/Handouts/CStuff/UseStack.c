#include <stdio.h>
#include <stdlib.h>
#include "Stack.h"

/* This program uses the simple stack we have
 * created and pushes some numbers on the
 * stack and pops them off again.
 */
int main(int argc,char ** argv) {
  int i,k;
  createStack();
  k=0;
  for(i=5;i<100;i=i+5) {
    printf("%5d",i);
    push(i);
    if((k+1)%5==0) printf("\n");
    k++;
  }
  printf("\n");
  printf("\n");

  k=0;
  while(!isEmpty()) {
    printf("%5d",pop());
    if((k+1)%5==0) printf("\n");
    k++;
  }
  printf("\n");
  pop();
  printf("We don't get here.\n");
}
