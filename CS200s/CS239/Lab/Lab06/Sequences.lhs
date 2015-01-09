>	module Sequences where
>	import Ratio

CS239 Lab6  Haskell ...  sequences

two example sequences. The first uses fractions, the second Doubles.

>	inverses = [(1%(n*n)) | n <- [1..] ]

>	inverses2 = [1/(n*n) | n <- [1..] ]

function sequencePrint n aList returns a list of the first n elements
of aList. If aList is length less than n it just returns aList.

>	sequencePrint n [] = []
>	sequencePrint n (x:theRest)
>		| (n>0) = x : (sequencePrint (n-1) theRest)
>		| (n<=0) = []

>	sequenceSum n [] = 0
>	sequenceSum n (x:theRest)
>		|  (n<=0) = 0
>		|  (n>0) = x + (sequenceSum (n-1) theRest)


In this lab, you should start by testing the above method on the
two sample lists using n=1, n=5, n=10, n=100, n=1000, n=10000, n=15000.
Then write a method called sequenceSum n aList which will add up the
first n elements of aList.

Try it out on inverses and inverses2 to see what you get. In particular
you should try the same values of n on each list. (When you try it on
inverses you should only do n=5,10,100,1000.)

When you do it on inverses2 you should see it getting closer and
closer to the value pi*pi/6 which is approximately 1.645.

Now create a new sequence with 1/n in it. Then try sequenceSum on
the same set of values of n.

>	sequence1 = [(1/n) | n <- [1..] ]

Create method alternatingSum n aList which adds up the terms in
aList by alternating plus and minus signs. Do this by modifying 
your sequenceSum method so it subtracts the remaining sum instead
of adding it. Now run this on each series with the same values of n.

>	alternatingSum n [] = 0
>	alternatingSum n (x:theRest)
>		|  (n<=0) = 0
>		|  (n>0) = x - (alternatingSum (n-1) theRest)


Finally, 1+1/2+1/3+...+1/n - ln(n) converges to a constant. Calculate
a few decimal places of this constant by creating the sequence {1/k},
adding up n terms and subtracting ln(n) for n=100, 1000, 10000. (This
difference should get close to 0.57721 as n gets larger.) To 
calculate ln(n) in Haskell, you type log n

