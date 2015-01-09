/*
 * File: ex1_5.c
 *
 * Robbins & Robbins, Ex. 1.5
 * Modified 2010/08/25, JAH
 */

#include <stdio.h>
#include <string.h>

int main() {

  char buf[20];
  size_t nchars;

  printf("Enter your first name: ");
  scanf("%19s", buf);
  nchars = strlen(buf);

  printf("Hello, hello, hello... %s!\n", buf);
  printf("Your name contains %d characters.\n", nchars);

  return 0;
}
