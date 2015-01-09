#include <stdio.h>
#include <stdlib.h>
int main(int argv, char ** args) {
   FILE *fp;
   int i;
   
   fp = fopen("results2.dat", "w");
   if (fp == NULL) {
      printf("I couldn't open results.dat for writing.\n");
      exit(0);
   }
   
   for (i=3; i<=12; ++i) {
      fprintf(fp, "%d, %d\n", i, i*i);
   }
   return 0;
}
