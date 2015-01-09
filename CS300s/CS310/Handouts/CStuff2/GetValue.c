#include <stdio.h>
int getAnInt(char * message) {
  int j;
  printf("%s ",message);
  scanf("%d",&j);
  return(j);
}
