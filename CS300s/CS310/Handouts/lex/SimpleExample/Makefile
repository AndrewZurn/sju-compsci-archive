lextest		: lex.o lextest.o
		cc -o lextest lex.o lextest.o -ll
lex.o		: lex.c
		cc -c lex.c
lex.c		: lex.l lex.h
		flex lex.l
		mv lex.yy.c lex.c
lextest.o	: lextest.c
		cc -c lextest.c
