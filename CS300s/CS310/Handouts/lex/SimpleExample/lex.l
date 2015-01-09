%{
#include "lex.h"
extern int intvalue;

%}
%Start T
%%
<T>" "|"\t"|"\n"           ;
<T>[a-z]+[a-z,0-9]*        {printf("VARIABLE ");}
<T>[0-9]*"."[0-9]*         {printf("REAL ");}
<T>[0-9]{1,7}              {printf("INTEGER ");}
<T>"="                     {printf("EQUAL ");}
<T>";"                     {printf("SC ");}
<T>"("                     {printf("LP ");}
<T>")"                     {printf("RP ");}
<T>"+"                     {printf("PLUS ");}
<T>"-"                     {printf("MINUS ");}
<T>"*"                     {printf("TIMES ");}
<T>"/"                     {printf("DIVIDE ");}
<T>"^"                     {printf("EXP ");}
<T>"{"                     {printf("LEFTBRACKET ");}
<T>"}"                     {printf("RIGHTBRACKET ");}
<T>.                       {printf("ERROR ");}
%%
lexinit() {
    BEGIN T;
  }
