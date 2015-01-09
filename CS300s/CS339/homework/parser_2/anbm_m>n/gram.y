%{
int intvalue;
extern char yytext[];
extern int values[];
char variablename[200];
%}

%token A
%token B
%token END
%token BADCC

%%
s		: A s B		{printf("S -> a S b\n");}
		| p		{printf("S -> P\n");}
		;
p		: B p END	{printf("P -> b P\n");}
		| B		{printf("P -> b\n");}
		;
%%
