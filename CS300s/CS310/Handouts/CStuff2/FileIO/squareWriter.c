#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main(int argv, char ** args) {
   FILE *fp;
   int i,j,m,n;
   
   fp = fopen(args[1], "w");
   if (fp == NULL) {
      printf("I couldn't open results.dat for writing.\n");
      exit(0);
   }
   m=args[2][0]-'0';
   for(j=1;j<strlen(args[2]);j++) {
      m=m*10+args[2][j]-'0';
   }
   n=args[3][0]-'0';
   for(j=1;j<strlen(args[3]);j++) {
      m=m*10+args[3][j]-'0';
   }
   for (i=m; i<=n; i++) {
      fprintf(fp, "%d, %d\n", i, i*i);
   }
   return 0;
}
