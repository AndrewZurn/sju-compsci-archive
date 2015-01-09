#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "stack.h"

int main(int argc,char ** argv){
  Stack stack = makeStack();
  push(stack, (void *) 1);
  push(stack, (void *) 2);
  printf("The current variable on top of the stack is: %s \n", peek(stack));
  push(stack, (void *) 3);
  push(stack, (void *) 4);
  push(stack, (void *) 5);
  push(stack, (void *) 6);
  push(stack, (void *) 7);
  printf("Popping from the stack will produce: %s \n", pop(stack));
  int empty = isEmpty(stack);
  if( empty == 1 ){ return -1;}
  else if(empty == 0){return 0;}
  while( isEmpty(stack) != 1 ){
    printf("Popping from the stack will produce: %s \n", pop(stack));
  }
  freeStack(stack);
}
