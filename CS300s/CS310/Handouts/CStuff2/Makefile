stackDemo: UseStack.o Stack.o GetValue.o
	gcc -o stackDemo UseStack.o Stack.o GetValue.o
UseStack.o: UseStack.c Stack.h GetValue.h
	gcc -c UseStack.c
Stack.o: Stack.c
	gcc -c Stack.c
GetValue.o: GetValue.c
	gcc -c GetValue.c
