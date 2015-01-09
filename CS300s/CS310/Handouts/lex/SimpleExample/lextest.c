#include <stdio.h>
#include "lex.h"

extern int yylineno;
char yytext[200];
int intvalue;
int tcode;

main() {
  lexinit();
  while (tcode = yylex() ) {
    switch(tcode) {
        case REAL: printf(" REAL (%s) ",yytext); break;
        case EQUAL: printf(" ASSIGNMENT= "); break;
        case LP: printf(" LP( "); break;
        case RP: printf(" RP) "); break;
	case VARIABLE: printf(" VARIABLE( %s ) ",yytext); break;
	case SC: printf(" SC;\n"); break;
	case PLUS: printf(" PLUS+ "); break;
	case MINUS: printf(" MINUS- "); break;
	case TIMES: printf(" TIMES* "); break;
	case DIVIDE: printf(" DIVIDE/ "); break;
	case EXP: printf(" EXP^ "); break;
	case INTEGER: printf(" INTEGER( %d ) ",intvalue); break;
	case ERROR: printf(" ERROR( %c ) in line %d ",yytext[0],yylineno); break;
	}
  }
  printf("\n");
}
