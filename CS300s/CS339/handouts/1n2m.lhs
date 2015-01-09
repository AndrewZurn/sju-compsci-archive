>	state0 [] [] =[1]
>	state0 [] (x:theRest)
>		| x==1 = state1 [] theRest
>		| x==2 = state2 [] theRest
>		| otherwise = [0]

>	state1 [] [] =[1]
>	state1 [] (x:theRest)
>		| x==1 = state1 [] theRest
>		| x==2 = state2 [] theRest
>		| otherwise = [0]

>	state2 [] [] = [1]
>	state2 [] (x:theRest)
>		| x==2 = state2 [] theRest
>		| otherwise = [0]


