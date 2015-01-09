%{
#include "y.tab.h"
extern int intvalue;
extern char variablename[];
%}
%Start T C
%%
<T>" "|"\t"|"\n"           ;
<T>[a-z]+                  {strcpy(variablename,yytext); return(VARIABLE);}
<T>[0-9]{1,7}              {intvalue=atoi(yytext); return(INTEGER);}
<T>";"                     {return(SC);}
<T>"("                     {return(LP);}
<T>")"                     {return(RP);}
<T>"+"                     {return(PLUS);}
<T>"-"                     {return(MINUS);}
<T>"*"                     {return(TIMES);}
<T>"/"                     {return(DIVIDE);}
<T>"^"                     {return(EXP);}
<T>"{"                     {BEGIN C;}
<T>.                       {return(BADCC);}
<C>"}"                     {BEGIN T;}
<C>.                       ;
%%
void lexinit() {
    BEGIN T;
  }







