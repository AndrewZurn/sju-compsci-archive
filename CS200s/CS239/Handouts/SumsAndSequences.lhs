
>	import Ratio

get the first n elements of the sequence

>	subSequence n [] = []
>	subSequence 0 l = []
>	subSequence n (x:theRest) = x : (subSequence (n-1) theRest)

create the sequence [1,1/2,1/3,1/4,1/5,1/6,...] - the harmonic sequence

>	harmonicSequence = [1%n | n<-[1..]]

create the alternating harmonic sequence [1,-1/2,-1/3,...]

>	alternatingSequence = [(if((mod n 2)==0) then -1 else 1)%n | n<-[1..]]

>	addEmUp [] = 0
>	addEmUp (x:theRest) = x + (addEmUp theRest)

>	addFirstN n l = addEmUp (subSequence n l)

>	harmonicSequence2 = [1.0/n | n<-[1..]]

>	displayFirst l 0 = []
>	displayFirst [] n = []
>	displayFirst (x:theRest) n = x:(displayFirst theRest (n-1))

