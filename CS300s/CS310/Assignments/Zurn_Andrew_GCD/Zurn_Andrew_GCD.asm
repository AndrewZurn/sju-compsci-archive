#GCD author: Andrew Zurn since: Apr 3, 2012
DATA
PROGRAM
	READ R2
	READ R3

#Condition 1: m<0 ---------------------------------------------------------------
	SUB SCR R2 ONE
	BRNG Cond1
	JUMP pastCond1
Cond1
	NOT R2 R2
	ADD R2 R2 ONE
pastCond1

#Condition 2: n<0 ---------------------------------------------------------------
	SUB SCR R3 ONE
	BRNG Cond2
	JUMP pastCond2
Cond2
	NOT R3 R3
	ADD R3 R3 ONE
pastCond2

#Condition 3: m==0 --------------------------------------------------------------
gcd
	SUB SCR R2 ONE
	BRNG returnM
	JUMP pastReturnM
returnM
	WRITE R3
	JUMP jumpEnd
pastReturnM

#Condition 4: n==0 --------------------------------------------------------------
	SUB SCR R3 ONE
	BRNG returnN
	JUMP pastReturnN
returnN
	WRITE R2
	JUMP jumpEnd
pastReturnN

#Condition 5: n<m ---------------------------------------------------------------
	SUB SCR R2 R3
	BRZR nGreaterThanM
	BRNG nGreaterThanM
	SUB R2 R2 R3
	JUMP gcd
#Condition 6: m<n ---------------------------------------------------------------
nGreaterThanM
	SUB R3 R3 R2
	JUMP gcd

jumpEND
HALT
END
