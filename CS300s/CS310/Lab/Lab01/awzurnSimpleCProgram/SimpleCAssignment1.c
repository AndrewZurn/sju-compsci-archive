#include <stdio.h>
#include <stdlib.h>

int main (int argc, char ** argv){
double array[20];
int j=0;
while(scanf("%lf",&array[j])!=EOF) {
    j++;
  }
int k=0;
double sum,sqrsum,cubsum=0;
for(k=0;k<j;k++) {
    sum = sum + array[k];
    sqrsum= sqrsum + (array[k] * array[k]);
    cubsum= cubsum + (array[k] * array[k] * array[k]);
}
printf("The sum of the inputed numbers is: %f\n", sum);
printf("The sum of the inputed numbers squared is: %f\n", sqrsum);
printf("The sum of the inputed numbers cubed is: %f\n", cubsum);
}
