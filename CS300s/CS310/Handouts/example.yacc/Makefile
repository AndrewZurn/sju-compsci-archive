grammartest : gram.o lex.o yacctest.o
		cc -o yacctest gram.o lex.o yacctest.o -ll
yacctest.o  : yacctest.c
		cc -c yacctest.c
gram.o      : gram.c
		cc -c gram.c
gram.c      : gram.y
		yacc -dv gram.y
		mv y.tab.c gram.c
gram.y      : gram.tok gram.prod
		cat gram.tok gram.prod > gram.y
lex.o       : y.tab.h lex.c
		cc -c lex.c
lex.c       : lex.l
		flex lex.l
		mv lex.yy.c lex.c
clean       : 
		rm  *.o *~ gram.y gram.c lex.c y.output y.tab.h yacctest

