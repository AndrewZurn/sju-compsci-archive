DATA
	x 5*5,4*4,3*3,2*2,1
PROGRAM
	#We always initialize the stack to someplace way down in memory
	#-3 expands out to 111111111111101 - two places from the end of memory
	imlo sp -3

	#imm R2 x translates into imlo R2 lower half of x's address
	#followed by imhi R2 upper half of x's address
	imm R2 x
	
	#read r2 translates into imlo scr 0xfe
	#followed by load R2 [scr]
	read r2
	
	#write r2 translates into imlo scr 0xff
	#followed by stor [scr] R2
	write r2
	
	#not R3 R2 translates into NXOR R3 R2 ZERO
	not r3 r2
	
	#neg r4 r2 translates into sub r4 zero r2
	neg r4 r2

	#push r2 translates into sub sp sp one then stor [sp] r2
	push r2

	#pop r5 translates into load r5 [sp] then add sp sp one
	pop r5

	#copy r3 r2 translates into or r3 r2 r2
	copy r3 r2

	#call subroutine translates into add RA PC ONE
	#followed by jump subroutine
	call  subroutine
	write r6
	halt
	

subroutine	write r4
	#ret translates into or pc ra ra
	ret
END
