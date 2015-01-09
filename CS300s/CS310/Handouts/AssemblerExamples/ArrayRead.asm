DATA
PROGRAM
#//Note we only reproduce the main program
#//This program deals with arrays. numInArray is the number
#// of things in the array we read in
#  numInArray=Read();
		IMLO R10 0xFE
		LOAD R3 [R10]    #R3 is numInArray
#  //Read in the array
#  int [] x=new int[numInArray];
		IMLO R4 0x7F        #R4 is the adress
		IMLO R5 0x7F
#  int index=0;
		IMLO R6 0        #R6 is index
#  while(index<numInArray) {
while	SUB SCR R3 R6
		BRNG TheEnd
		BRZR TheEnd
#    x[index]=Read();
		LOAD SCR [R10]   #SCR contains the next value
		STOR [R5] SCR    #Put that value out in the array
		ADD  R5 R5 ONE    #Prepare for the next value in
		                 #the array
#    index=index+1;
		ADD  R6 R6 ONE
#  }
		JUMP while
TheEnd	HALT
END