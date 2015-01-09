DATA
	x 8*7,7*6,6*5,5*4
PROGRAM
	#To treat something like an array, you need a register to hold
	#the address of the beginning of the array and another register
	#to hold the index. Here we treat x as an array. R2 will hold
	#the address of x and R3 will hold the index.
	imm R2 x
	#start with the variable R6=0
	imlo R6 0
	#we will simulate the following:
	#for(int R3=0,R3<25,R3++) {
	imlo R3 0
	#we will repeat our "for loop" 25 times. R4 will hold 25.
	imlo R4 25
for	sub SCR R4 R3
	brzr pastfor
	brng pastfor
		#R5 will contain the address x[i]
		add R5 R2 R3
		load scr [r5]
		#r6=r6+x[i]
		add r6 r6 scr
		#i=i+1
		add r3 r3 one
	jump for
pastfor	write r6
	halt
END
		
		
	