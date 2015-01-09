#include <stdio.h>

main() {
  while(1) {
    lexinit();
    yyparse();
  }
  return(0);
}

void yyerror() {}

