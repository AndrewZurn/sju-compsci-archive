/*
 * File: stack.c
 * Author: Andrew Zurn
 * Due Date: 9/14/2012
 */

#include "stack.h"
#include "errno.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
  
  
  #define INIT_CAPACITY 4
  
  struct stackStruct {
  int capacity;   // the number of elements allocated in elems
  int size;       // number of elements currently on the stack
  void **elems;  // array of pointers to stack elements
};

Stack makeStack(){
  struct stackStruct s;
  Stack ss;
  s.capacity = INIT_CAPACITY;
  s.capacity = INIT_CAPACITY;
  s.size = 0;
  if ( (s.elems = (void **) malloc(s.capacity * sizeof(char))) == NULL ){
    return NULL;
  }
  return ss;
}

int push(Stack stack, void *elem){
  int i = 0;
  struct stackStruct ss;
  if( ss.size >= 4 ){
    void **newElems;
    ss.capacity = ss.capacity * 2;
    if ( (newElems = (void **) malloc(ss.capacity * sizeof(char))) == NULL ){
      free(ss.elems);
      errno = -1;
      return -1;
    }
    while(ss.elems[i] != NULL){
      newElems[i] = ss.elems[i];
    }
    free(ss.elems);
    *ss.elems = *newElems;
    ss.elems[ss.size + 1];
    ss.size++;
    return 0;
  }
  else{
    ss.elems[ss.size + 1];
    ss.size++;
    return 0;
  }
}

int isEmpty(Stack stack){
  struct stackStruct ss;
  if( ss.size == 0 ){
    return 1;
  }
  else if( ss.size != 0 ){
    return 0; 
  }
  return -1;
}

void* pop(Stack stack){
  struct stackStruct ss;
  void* item;
  if ( ss.size == 0 ){
    return NULL;
  }
  else if ( (item = (void *) ss.elems[ ss.size ]) != NULL){
    ss.elems[ ss.size ] = NULL;
    ss.size--;
    return item;
  }
  else{
    return NULL;
  }
}

void* peek(Stack stack){
  struct stackStruct ss;
  void* item;
  if ( ss.size == 0 || stack == NULL){
    return NULL;
  }
  else if (( item = (void *) ss.elems[ ss.size ]) != NULL){
    return item;
  }
  else{
    return NULL;
  }
}

int freeStack(Stack stack){
  struct stackStruct ss;
  if( ss.size != 0  || stack == NULL){
    return -1; 
  }
  else{
    free(stack);
    free(ss.elems);
    return 0;
  }
}

int main(int argc, char ** argv){
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
