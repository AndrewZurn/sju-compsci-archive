Some set stuff:

>	import SetOperations
>	import Ratio

Pythagorean triples

>	pTriples=[(x,y,z) | z <- [3..], y<-[1..(z-1)], x<-[1..(y-1)], z*z==y*y+x*x]

>	addTo1000 []=(0,0,0)
>	addTo1000 ((x,y,z):theRest)=if((x+y+z)==1000) then (x,y,z) else (addTo1000 theRest)

Sieve of Aristhosthenes

>	sieve [] = []
>	sieve (x:theRest) = x : (sieve [y | y <- theRest, (mod y x)>0])

primes using the Sieve

>	primes = sieve [2 .. ]

>	fib 0 = 1
>	fib 1 = 1
>	fib n = (fib (n-1)) + (fib (n-2))

>	fibs = [fib x | x<-[1..]]

applyNTimes

>	applyNTimes f n [] = []
>	applyNTimes f 0 l = []
>	applyNTimes f n (x:theRest) = (f x):(applyNTimes f (n-1) theRest)

applyFunction

>	applyFunction f [] = []
>	applyFunction f (x:theRest) = (f x) : (applyFunction f theRest)

iterate n times

>	iteraten f x n
>		| (n<0) = []
>		| otherwise = x : (iteraten f (f x) (n-1))

iterate infinite times

>	iterateInf f x = x : (iterateInf f (f x))

set of iterates of squares

>	square x = x*x

>	twoSquares = iterate square 2

firstn

>	firstn n [] = []
>	firstn 0 l = []
>	firstn n (x:theRest) = x:(firstn (n-1) theRest)

lcd

>	lcd m n
>		| m<0 = lcd (-m) n
>		| n<0 = lcd m (-n)
>		| n==0 = m
>		| m==0 = n
>		| otherwise = lcd (mod n m) m

createSequence

>	createSequence f [] = []
>	createSequence f (x:theRest) = (f x):(createSequence f theRest)

1/n^2

>	invertedSquares=[1%(n*n) | n<-[1..]]

converting Integer quantities to Double

>	intToFloat n = fromInteger (toInteger n)

>	odds=[1,3..]

>	odds2=[2*x+1 | x<-[0..]]

>	pairs1=[(2,5),(3,6),(7,2)]
>	pairs2=[(x,x+1) | x<-[0..]]

>	lookupInPair z ((x,y):l) = if(z==x) then y else lookupInPair z l

>	f x = lookupInPair x pairs1

>	g x = lookupInPair x pairs2

