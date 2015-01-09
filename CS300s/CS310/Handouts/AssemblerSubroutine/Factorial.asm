DATA
PROGRAM
	#As usual, we initialize the stack in the main program.
	# THIS IS NECESSARY!
	imlo sp 0xfe
	#This time we compute n! recursively
	read scr
	push scr
	call factorial
	pop r2
	write r2
	halt

factorial
	#This computes n! for parameter n.		
	#This is an example of a recursive program
	#Since we return one value, the parameter spot will
	# work to hold it so we need no extra stack space
	#It is NECESSARY that we save the ra and register r2 and r11
	#However, we want the frame pointer (r11) to point to the
	# parameter n. Since sp points to that parameter n we first
	# copy sp into scr:
	copy scr sp
	#Now push ra, r2, r11
	push ra
	push r2
	push r11
	#Now we copy scr into r11 so r11 points to the parameter.
	copy r11 scr
	#now we put the parameter which r11 points to into scr
	load scr [r11]
	#We need to check if the 
	sub scr scr zero
	#If n was zero, we jump to a place that returns 1.
	brzr returnOne
	#If n was negative, we can't computer n! so we just return 0.
	brng returnZero
	#If we get here n>0 so we call recursively factorial(n-1)
	#Since scr contains n, we subtract 1 giving it the value n-1, 
	# push that value (n-1), and call factorial(n-1).
	sub scr scr one
	push scr
	call factorial
	#get the returned result - which should be (n-1)!
	pop scr
	#Get the old parameter (n)
	load r2 [r11]
	#Multiply n*(n-1)!
	mult scr scr r2
	#scr now contains n! so we put the result back on the stack
	# where the frame pointer (r11) points in preparation for returning.
	stor [r11] scr
	#Now pop off the saved registers and return
	pop r11
	pop r2
	pop ra
	ret

returnOne
	#This one means we are computing 0!=1
	#Pop off the pushed registers and the parameter and push 1
	pop r11
	pop r2
	pop ra
	#Also pop off the parameter value n on the stack
	pop scr
	#and push on the answer
	push one
	ret

returnZero
	#This one means we are trying to calculate factorial
	# of a negative number. We return 0. First of all, we
	# pop off the saved registers and the parameter n
	pop r11
	pop r2
	pop ra
	#Then we pop off the parameter n
	pop scr
	#Then we push on the answer - 0
	push zero
	ret
END
