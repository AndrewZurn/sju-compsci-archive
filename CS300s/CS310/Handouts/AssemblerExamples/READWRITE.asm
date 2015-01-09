DATA
	X	50*77
	#This program reads in, first, the number of things to be read in.
	#Then it reads them in. Then, finally, it runs through a loop which
	#gets the values from the array and multiplies them together and, when
	#finished, prints out that product.
PROGRAM
	#Read n (R2 is n)
	READ R2
	#m=0  (R3 is m)
	IMLO R3 0
	#z=addressOf(x)  (R5 is z)
	IMM R5 X
	#y=z   (R6 is y)
	ADD R6 R5 ZERO
	#While(n>m) {
condition SUB SCR R2 R3
		BRNG pastWhile
		BRZR pastWhile
		#read x[n]
		READ R7
		STOR [R6] R7
		#m=m+1
		ADD R3 R3 ONE
		#y=y+1 (next address in array)
		ADD R6 R6 ONE
	JUMP condition
	#z=x[0] (R8 is z)
pastWhile	LOAD R8 [R5]
	#m=1
	IMLO R3 1
	#make R6 point to x[1]
	ADD R6 R5 ONE
	#while(n>m)
condition2	SUB SCR R2 R3
		BRNG pastWhile2
		BRZR pastWhile2
		#R7=x[m]
		LOAD R7 [R6]
		#R8=R8*x[m]
		MULT R8 R8 R7
		#m=m+1
		ADD R3 R3 ONE
		#m=m+1
		ADD R6 R6 ONE
	JUMP condition2
	#write z
pastWhile2	WRITE R8
	HALT
END