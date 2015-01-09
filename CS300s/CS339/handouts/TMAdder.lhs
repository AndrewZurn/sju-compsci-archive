>	state1 left (1:theRest) = state1 (1:left) theRest
>	state1 left (0:theRest) = state2 (1:left) theRest

>	state2 (1:theRest) [] = state3 theRest [1]
>	state2 left (1:theRest) = state2 (1:left) theRest

>	state3 (1:theRest) [1] = state4 theRest [1]

>	state4 (1:theRest) [1] = state5 theRest [1]

>	state5 [] right = right
>	state5 (1:theRest) right =state5 theRest (1:right)

