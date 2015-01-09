A function to square a number

>	square n = n * n


A function to double a number

>	double n =  2 * n


A function to compute the maximum of two numbers

>	max v1 v2
>	    | v1 > v2	= v1
>	    | otherwise	= v2

Here is another function to compute the maximum of two numbers

>	max2 v1 v2 = if(v1>v2) then v1 else v2

A recursive function to compute the largest common divisor of two integers

>	lcd m 0 = m
>	lcd 0 n = n
>	lcd m n = lcd n (mod m n)



>	applyThem [] x = []
>	applyThem (f:l) x = (f x):(applyThem l x)

>	applyIt f [] = []
>	applyIt f (x:l) = (f x):(applyIt f l)

A function to find the fourth power of a number

>	fourth n = square(square(n))

A function to find the eigth power of a number

>	eighth n = square(square(square(n)))



Write a function to fourth to calculate the 4th power of n. Use square twice.
Then write a function to calculate the 8th powerof n combining fourth 
and square.
