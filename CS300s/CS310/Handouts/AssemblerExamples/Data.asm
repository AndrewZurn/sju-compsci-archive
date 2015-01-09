DATA
	#This program illustrates how data is defined for the programs.
	X	10*1,5
	Y	7
PROGRAM
	IMM R4 X
	IMM R5 Y
	ADD R6 R5 ONE
	IMLO R7 12
	STOR [R6] R7
	HALT
END
