DATA
	x 5*5,4*4,3*3,2*2,1
PROGRAM
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

	#copy r2 r3 translates into or r2 r3 r3
	copy r2 r3
	
	halt
END
