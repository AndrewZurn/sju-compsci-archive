%{
#include "lex.h"
extern int intvalue;

%}
%Start T C
%%
<T>" "|"\t"|"\n"           ;
<T>[a-z]+[a-z,0-9]*        {return(VARIABLE);}
<T>[0-9]*"."[0-9]*         {return(REAL);}
<T>[0-9]{1,7}              {intvalue=atoi(yytext); return(INTEGER);}
<T>"="                     {return(EQUAL);}
<T>";"                     {return(SC);}
<T>"("                     {return(LP);}
<T>")"                     {return(RP);}
<T>"+"                     {return(PLUS);}
<T>"-"                     {return(MINUS);}
<T>"*"                     {return(TIMES);}
<T>"/"                     {return(DIVIDE);}
<T>"^"                     {return(EXP);}
<T>"{"                     {BEGIN C;}
<T>.                       {return(ERROR);}
<C>"}"                     {BEGIN T;}
<C>.                       ;
%%
lexinit() {
    BEGIN T;
  }
