%option noyywrap
NZDIGIT [1-9]
DIGIT [0-9]
%%
{NZDIGIT}{DIGIT}*[ \n] {printf("number=%s", yytext);}
%%
int main()
{
  yylex();
}
