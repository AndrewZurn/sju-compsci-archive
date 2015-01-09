#include <stdio.h>
#include <stdlib.h>
/* This program shows how one can use structs
 * to produce something like classes (except
 * that only the data is there - not the methods).
 */
struct myStruct {
  int x;
  int y;
};
typedef struct myStruct MS;
void printstuff(MS q) {
  printf("q.x=%d q.y=%d\n",q.x,q.y);
}
int main(int argc,char ** argv) {
  MS *a,b,*c;
  a=malloc(sizeof(MS));
  c=malloc(sizeof(MS));
  b.x=5;
  b.y=7;
  a->x=4;
  a->y=3;
  (*c).x=8;
  (*c).y=14;
  printstuff(b);
  printstuff(*a);
  printstuff(*c);
  free(a);
  free(c);
}
