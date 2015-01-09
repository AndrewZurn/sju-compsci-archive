DATA
PROGRAM
	#This is an example of the use of a subroutine which returns 
	#lots of stuff.
	#First we prepare the stack. DON'T FORGET TO DO THIS 
	# IN THE MAIN PROGRAM.
	imlo sp 0xfe
	#read in three values for calling the subroutine
	#Push them onto the stack as arguments. (The subroutine expects
	# three numbers - x, y, and z.)
	#read x and push it
	read r2
	push r2
	#read y and push it
	read r2
	push r2
	#read z and push it
	read r2
	push r2

	#call subroutine. Subroutine returns 6 values 
	call  subroutine

	#we return here and pop and print the 8 values.
	pop r2
	write r2
	pop r2
	write r2
	pop r2
	write r2
	pop r2
	write r2
	pop r2
	write r2
	pop r2
	write r2
	pop r2
	write r2
	pop r2
	write r2
	halt

subroutine		
	#We almost always want to establish the frame pointer r11
	# to point to the last argument. Temporarily save the sp
	# value in scr.
	copy scr sp

	#we know that we got three arguments but will want 8 spots to put
	# the returned values. We push 5 extra "spaces" on the stack.
	push zero
	push zero
	push zero
	push zero
	push zero

	#If we needed local variables we would push them onto the stack
	# here. We don't, in this case.

	#Now we usually push the ra in case we want to call another subroutine.
	push ra
	#We will use r11 so push it to preserve it for the calling program
	push r11
	#Now we can copy that temporary scr value into r11 so r11
	# (our frame pointer) is pointing to the top argument.
	copy r11 scr
	#We are going to want to use r2, r3, r4 so we need to save the calling
	# program's r2, r3, r4.
	push r2
	push r3
	push r4
	
	#retrieve the three parameters - in reverse order because it is a stack
	# Note that we use the r11 (frame pointer) which we conveniently left
	# pointing to the parameters. r4 gets z.
	load r4 [r11]
	#We add one to r11 so it points to y.
	add r11 r11 one
	#r3 gets y.
	load r3 [r11]
	#We add one to r11 so it points to x.
	add r11 r11 one
	#r2 gets x.
	load r2 [r11]

	#Now we start doing the real work. We first compute r2+r3+r4
	add scr r2 r3
	add scr scr r4
	#Now we put this on the stack as our first returned value. Thus
	# the old first argument is destroyed and replaced by r2+r3+r4.
	stor [r11] scr
	#Make r11 point to the place where the second argument was.
	sub r11 r11 one
	#We now calculate r2+r3-r4
	add scr r2 r3
	sub scr scr r4
	#r2+r3-r4 replaces the second argument
	stor [r11] scr
	#r11 changes to point to where the third argument was.
	sub r11 r11 one
	#We now calculate r2-r3+r4
	sub scr r2 r3
	add scr scr r4
	#put r2-r3+r4 where the third argument was. Then change r11 to
	#point to where the next returned value should be.
	stor [r11] scr
	sub r11 r11 one
	#r2-r3-r4 replaces the first "spare" returned value.
	sub scr r2 r3
	sub scr scr r4
	stor [r11] scr
	sub r11 r11 one
	#-r2+r3+r4 replaces the second "spare" returned value.
	sub scr r3 r2
	add scr scr r4
	stor [r11] scr
	sub r11 r11 one
	#-r2+r3-r4 replaces the third "spare" returned value.
	sub scr r3 r2
	sub scr scr r4
	stor [r11] scr
	sub r11 r11 one
	#-r2-r3+r4 replaces the fourth "spare" returned value.
	sub scr r4 r2
	sub scr scr r3
	stor [r11] scr
	sub r11 r11 one
	#-r2-r3-r4 replaces the fifth "spare" returned value.
	neg scr r2
	sub scr scr r3
	sub scr scr r4
	stor [r11] scr
	#Notice we do not change r11. We will make sp have this value later.
	#Now we restore the saved registers
	pop r4
	pop r3
	pop r2
	#Eventually, we need to make the sp point where s11 points. We also
	# need to restore r11. Thus, we temporarily put r11 into scr.
	copy scr r11
	#Restore r11 and ra.
	pop r11
	pop ra
	#restore the sp from the value saved in scr.
	copy sp scr
	#and return
	ret
END
