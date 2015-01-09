grammartest : gram.o lex.o yacctest.o
		gcc -o yacctest gram.o lex.o yacctest.o -ll
yacctest.o  : yacctest.c
		gcc -c yacctest.c
gram.o      : gram.c
		gcc -c gram.c
gram.c      : gram.y
		yacc -dv gram.y
		mv y.tab.c gram.c
gram.y      : gram.tok gram.prod
		cat gram.tok gram.prod > gram.y
lex.o       : y.tab.h lex.c
		gcc -c lex.c
lex.c       : lex.l
		lex lex.l
		mv lex.yy.c lex.c
clean       : 
		rm  *.o *~ gram.y gram.c lex.c y.output y.tab.h yacctest

