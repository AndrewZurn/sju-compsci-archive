#include <stdio.h>
#include <stdlib.h>

/* This is a demonstration program meant
 * to show how arrays are used and created
 * in C.
 */
int main(int argc,char ** argv) {
  //Note both x and y are, in fact, pointers to a
  // place in memory where there are ints. int * x
  // should be read as "x is a pointer to a place
  // where ints dwell". int y[25] should be read as
  // "y is a pointer to a place where exactly 25 ints
  // dwell". x can have its size dynamically changed
  // while y is an array of fixed size 25. They also
  // dwell in different parts of memory.
  int * x,k,i=0,y[25];
  x=calloc(25,sizeof(int));
  scanf("%d",&x[0]);
  y[0]=x[0];
  while(x[i]>0) {
    i++;
    scanf("%d",&x[i]);
    y[i]=x[i];
  }
  for(k=0;k<i;k++) {
    printf("%5d",x[k]);
    if((k+1)%5==0) printf("\n");
  }
  printf("\n");
  for(k=0;k<i;k++) {
    printf("%5d",y[k]);
    if((k+1)%5==0) printf("\n");
  }
  printf("\n");
  /* Now we will read until end of file. */
  int j=0;
  while(scanf("%d",&x[j])!=EOF) {
    j++;
  }
  for(k=0;k<j;k++) {
    printf("%5d",x[k]);
    if((k+1)%5==0) printf("\n");
    } 
  free(x);
}
