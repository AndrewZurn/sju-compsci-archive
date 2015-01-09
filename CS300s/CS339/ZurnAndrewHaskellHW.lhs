This program will find if the number of 1's input into the program is
half that of the amount of 2's entered.

To call the program, using something like
	state0 [] [1,2,2]

>	state0 [] [] =[1]
>	state0 [] (x:theRest)
>		| x==1 = state1 x theRest
>		| x==2 = [0]
>		| otherwise = [0]

>	state1 y (x:theRest)
>		| x==1 = state1 (y+1) theRest
>		| x==2 = state2 y 1 theRest
>		| otherwise = [0]

>	state2 y z (x:theRest)
>		| theRest == [] = state3 y (z+1)
>		| x == 1 = [0]
>		| x == 2 = state2 y (z+1) theRest
>		| otherwise = state3 y z

>	state3 y z
>		| (2*y) == z = [1]
>		| otherwise = [0]
