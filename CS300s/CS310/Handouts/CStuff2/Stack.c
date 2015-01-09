/* This is a simple implementation of a stack. Note
 * that it is a bit like a class in that it has a
 * series of data items and some methods that can
 * be used to create an integer stack and manipulate
 * it in the usual way.
 */

#include <stdlib.h>

/* node is one node in the list-like implementation. */
struct node {
  int value;
  struct node * next;
};

/* We create the new type stackNode. */
typedef struct node stackNode;

/* start is always pointing to the top of the stack. */
stackNode * start;

/* createNode(int val) creates a new stackNode containing
 * the data item val. */
stackNode * createNode(int val) {
  stackNode * temp;
  temp=malloc(sizeof(stackNode));
  temp->value=val;
  temp->next=NULL;
  return temp;
}

/* createStack() creates a new stack. */
void createStack() {
  start=NULL;
}

/* push(int val) "pushes" val onto the stack. */
void push(int val) {
  stackNode * temp=createNode(val);
  temp->next=start;
  start=temp;
}

/* isEmpty() returns true if the stack is empty,
 * false otherwise. */
int isEmpty() {
  return(start==NULL);
}

/* pop() returns the item on the top of the stack. If
 * the stack is empty, it exits with error condition 1.
 * Note how it removes the old node. */
int pop() {
  if(!isEmpty()) {
    stackNode * tempPointer=start;
    int temp=start->value;
    start=start->next;
    free(tempPointer);
    return temp;
  }
  else exit(1);
}
