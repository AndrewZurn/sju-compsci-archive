%{
#include "y.tab.h"
extern int intvalue;
extern char variablename[];
%}
%Start T
%%
<T>a                      {return(A);}
<T>b                      {return(B);}
<T>#                      {return(END);}
<T>.			  {printf("Bad Character\n");return(BADCC);}
%%
void lexinit() {
    BEGIN T;
  }







