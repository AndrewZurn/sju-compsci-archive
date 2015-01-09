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

A recursive function to compute the least common divisor of two integers

>	lcd m 0 = m
>	lcd m n = lcd n (m `mod` n)


sample function using the "where" clause

>       xxx n 
>            | n > 0 = nCubed + nSquared
>            | otherwise = -nCubed + nSquared
>                 where nCubed = n*n*n
>                       nSquared = n * n

Quadratic polynomial fuction (ax^2 + bx + c).

>	quadpoly a b c x  = square(x)*a + (b*x) + c

Polynomial 3x^2 - 25x + 7

>	poly1 x = quadpoly 3 (-25) 7 x

Cube a number

> 	cube x = x*x*x

Cubic polynomial ax^3 + bx^2 + cx + d

>	cubicpoly a b c d x = cube(x)*a + quadpoly b c d x

Polynomial x^3 - 5.359375

>	poly2 x = cubicpoly 1 0.0 0.0 (-5.359375) x

Determines whether or not a triangle is equilateral, isoceles, or scalene.
	Create the data type used in triangle.

>	data TriangleTypes = Scalene | Isoceles | Equilateral
>	instance Show TriangleTypes where
>		show Scalene = "Scalene" 
>		show Isoceles = "Isoceles"
>		show Equilateral = "Equilateral"

Create the comparing function in triangle.

>	triangle a b c = if((a==b) && (a==c)) then Equilateral else if((a==b) || (b==c) || (a==c)) then Isoceles else Scalene

Max of a list of integers

>	intmax :: [Int] -> Int
>	intmax []  = 0
>	intmax [n] = n
>	intmax (n1 : n2 : ns) = if n1 > n2 then (intmax (n1 : ns)) else (intmax (n2 : ns));

Min of a list of doubles

>	doublemin :: [Double] -> Double
>	doublemin []  = 0
>	doublemin [n] = n
>	doublemin (n1 : n2 : ns) = if n1 > n2 then (doublemin (n2 : ns)) else (doublemin (n1 : ns));

Compute the sum of a list of integers

>	intsum :: [Int] -> Int
>	intsum []  = 0
>	intsum [n] = n
>	intsum (n : ns) = n + intsum ns;

Compute average of a list of numbers

>	listLength :: [Double] -> Double
>	listLength [] = 0
>	listLength (n:ns) = 1 + listLength ns;

>	averageList :: [Double] -> Double
>	averageList [] = (-1)
>	averageList (n:ns) = (doublesum (n:ns)) / (listLength (n:ns));

Compute the sum of a list of doubles

>	doublesum :: [Double] -> Double
>	doublesum []  = 0
>	doublesum [n] = n
>	doublesum (n : ns) = n + doublesum ns;
