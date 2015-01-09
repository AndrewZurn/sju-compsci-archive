#include <stdio.h>
#include <stdlib.h>
#include "Stack.h"
#include "GetValue.h"
/* This program uses the simple stack we have
 * created and pushes some numbers on the
 * stack and pops them off again.
 */
int main(int argc,char ** argv) {
  int i,k,beginning,last,increment;
  createStack();
  beginning=getAnInt("Enter the lowest value:");
  last=getAnInt("Enter the highest value:");
  increment=getAnInt("Enter the increment");
  k=0;
  for(i=beginning;i<last;i=i+increment) {
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
