DATA
PROGRAM
#Read(n);
		IMLO R10 0xFE
		IMLO R11 0xFF
		LOAD R3 [R10]    #R3 is n
#sum=0;
		IMLO R4 0       #R4 is sum
#index=1;
		IMLO R5 1       #R5 is index
#while(index<=n) {
While	SUB SCR R3 R5   #Calculate R3-R5=n-index
		BRNG Print      #When difference is negative
				# jump out of loop
#	sum=sum+index;
		ADD R4 R4 R5
#	index=index+1;
		ADD R5 R5 ONE
		JUMP While      #Go back to the while beginning
#}
#Print(sum);
Print	STOR [R11] R4
		HALT
END
