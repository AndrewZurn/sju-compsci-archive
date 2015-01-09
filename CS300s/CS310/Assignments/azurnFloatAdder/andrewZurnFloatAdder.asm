#FLOAT ADDER developed by Andrew Zurn, LAST REVISED 3/1/12, DUEDATE 3/2/12
DATA			#USE X and Y as variables to hold the floats
	X	0x4ac0 #3568 = 0x557c : 208 = 0x4d40
	Y	0x4d40 #1572 = 0x5312 : 88 = 0x4ac0
		       #Format = num1 + num2 = ans = unsigned Dec = Hex
		       #3568 + 1572 =~ 5140 = 22147 = 0x5683
		       #208 + 88 = 296 = 20048 = 0x4e50
	Z	512 #2^9 for masking
	E	0x7e00 #0111111000000000 for masking
	M	0x01ff	#0000000111111111
	A	0x0200	#0000001000000000
	MT	0x0001 #0000000000000001 for detecting if right most bit is 1
	MTH	0x0400 #0000010000000000 for detecting 11 bit
	MF	0xfdff #1111110111111111 for removing 10th bit
	TWO	2
	ONE	1
	ZERO	0
PROGRAM

#Step 1 ------------------------------------------------------------------------
		IMM R4 X
		IMM R5 Y
		LOAD R6 [R4] 	#X will be loaded into reg 6
		LOAD R7 [R5] 	#Y will be loaded into reg 7

condition0 	SUB SCR R6 R7		#Subtract X from Y
		BRNG pastCond	#If a negative flag is thrown, jump to pastCond
		Copy R2 R6	#Load R2 with X
		Copy R3 R7	#Load R3 with Y
		jump pastNegBR	#Jump to "here" as to avoid reloading R2 and R3

pastCond 	Copy R2 R7	#(alternative)Load R2 with Y
		Copy R3 R6	#(alternative)Load R3 with X
pastNegBR
#step 2 ------------------------------------------------------------------------
		IMM scr E	#sets up 0111111000000000 to mask in scr
		LOAD scr [scr]	#Loads E into scr
		AND R4 scr R2	#masks the exponent bits in X
		IMM scr Z	#Sets 2^9 into scr
		LOAD scr [scr]	#Load 2^9 into scr
		DIV R4 R4 scr	#Moves X's exponent bits 9 places right
		IMM scr E	#sets up 0111111000000000 to mask in scr
		LOAD scr [scr]	#Loads E into scr
		AND R5 scr R3	#masks the exponent bits in Y
		IMM scr Z	#Sets 2^9 in scr
		LOAD scr [scr]	#Load 2^9 into scr
		DIV R5 R5 scr	#Moves Y's exponent bits 9 places right
#step 3 ------------------------------------------------------------------------
		IMM scr M	#sets up 0000000111111111 to mask for mantissa
		LOAD scr [scr]	#Loads M into scr
		AND R6 R2 scr	#masks for mantissa of X
		IMM scr A	#sets up 0000001000000000 to add to mantissa
		LOAD scr [scr]	#Loads A into scr
		OR R6 R6 scr	
		IMM scr TWO
		LOAD scr [scr]
		MULT R6 R6 scr

		IMM scr M	#sets up 0000000111111111 to mask for mantissa
		LOAD scr [scr]	#Loads M into scr
		AND R7 R3 scr	#masks for mantissa of X
		IMM scr A	#sets up 0000001000000000 to add to mantissa
		LOAD scr [scr]	#Loads A into scr
		OR R7 R7 scr	
		IMM scr TWO
		LOAD scr [scr]
		MULT R7 R7 scr
#step 4-------------------------------------------------------------------------
		SUB R8 R4 R5	#to be used in for loop
		#for loop the number of times of the value stored in R8
		IMM R9 ZERO	#HERE IS YOUR PROBLEM?
		LOAD R9 [R9]	#HERE IS YOUR PROBLEM?
		#for(int R9=0,R9<R8,R9++) {
for		SUB scr R8 R9	#if R9>R8
		BRZR pastfor	#if zero is thrown jump to pastfor
		BRNG pastfor	#if neg num is thrown jump to pastfor
		IMM scr TWO	#set add for 2 into scr
		LOAD scr [scr]	#load 2 into scr
		DIV R7 R7 scr	#move r7 once to right
		ADD R9 R9 one	#HERE IS YOUR PROBLEM?
		jump for
pastfor
#step 5-------------------------------------------------------------------------
		ADD R8 R6 R7	#add the two numbers
		IMM scr MT	#loads rightmost mask into scr mem
		LOAD scr [scr]	#loads rightmost mask into scr
		AND R9 R8 scr	#sets R9 to and of scr and 00000000000000001
		IMM scr TWO
		LOAD scr [scr]
condition1	SUB R9 R9 one	#subtracts 1 from value R9 to see if  1 or 0
		BRNG pastCond2	
		BRZR pastCond3
pastCond2			#where the value R9, the rightmost bit of R8 was 0
		DIV R8 R8 scr	#shifts our number one bit right
		jump pastCond2and3
pastCond3			#where the value R9, the rightmost bit of R8 was 1
		DIV R8 R8 scr	#shifts our number one bit right
		ADD R8 R8 one	#adds 1 to our number
		jump pastCond2and3
pastCond2and3
#step 6-------------------------------------------------------------------------
		IMM scr MTH	#load mem loc of MTH (0000010000000000)
		LOAD scr [scr]	#load MTH into scr
		AND R9 R8 scr	#determine if 11th bit is 1 and load into R9
condition2	SUB R9 R9 scr	#subtract 1024 from masked R8 for 11th bit
		BRNG pastCond4	#if 11th bit is 0
		BRZR pastCond5	#if 11 bit is 1
pastCond4			#if 11th bit was 0
		IMM scr TWO
		LOAD scr [scr]
		DIV R8 R8 scr	#move R8 one to right
		jump condition3
pastCond5			#if 11th bit was 1
		IMM scr TWO
		LOAD scr [scr]
		AND R9 R8 one	#and R8 with 1 and put in R9
condition3	SUB R9 R9 one	#sub 1 from and of R8 and one
		BRNG pastCond6	#if rightmost bit was 0
		BRZR pastCond7	#if rightmost bit was 1
pastCond6			#if rightmost bit was 0
		DIV R8 R8 scr	#move R8 one right
		ADD R4 R4 one	#add 1 to exponent
		jump pastCond6and7
pastCond7			#if rightmost bit was 1
		DIV R8 R8 scr	#move R8 one right
		ADD R8 R8 one	#add 1 to R8
		ADD R4 R4 one	#add 1 to exponent
pastCond6and7 			
#step 7-------------------------------------------------------------------------
		IMM scr M
		LOAD scr [scr]
		AND R8 R8 scr
#step 8-------------------------------------------------------------------------
		IMM scr Z
		LOAD scr [scr]
		MULT R4 R4 scr
#step 9-------------------------------------------------------------------------
		OR R10 R8 R4
HALT
END
