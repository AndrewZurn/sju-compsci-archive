/*
 * File: stack.h
 */

#ifndef STACK_H
#define STACK_H

/*
 * Forward declaration of struct stack,
 * will be defined in stack.c
 */
struct stackStruct;

/**
 * Stack is the pointer type used to represent
 * stack of pointers to "objects"
 *
 * @author J. Andrew Holey
 * @version September 7, 2012
 */
typedef struct stackStruct *Stack;

/**
 * Returns a new empty Stack;
 * returns NULL and sets errno if
 * it fails to allocate the stack.
 * errno is set according specifications for malloc()
 */
Stack makeStack();

/**
 * Returns  1 if stack is empty,
 *          0 if it contains elements
 *         -1 if stack is NULL 
 */
int isEmpty(Stack stack);

/**
 * Adds elem to the top of stack and
 * returns 0;
 * returns -1 and sets errno if
 * memory allocation was required and failed
 */
int push(Stack stack, void *elem);

/**
 * Returns the top element of stack;
 * returns NULL if the stack was empty or NULL
 */
void* peek(Stack stack);

/**
 * Returns and removes the top element of stack;
 * returns NULL if the stack was empty or NULL
 */
void* pop(Stack stack);

/**
 * Deallocates memory used by stack and returns 0;
 * returns -1 and leaves stack unchanged if
 * stack is not empty or is NULL
 */
int freeStack(Stack stack);

#endif
