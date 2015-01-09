>	module SetOperations where
>	import Ratio

function removeXFromSet

>	removeXFromSet x [] = []
>	removeXFromSet x (y:theRest) =
>		if(x==y) then (removeXFromSet x theRest) 
>	        else (y:(removeXFromSet x theRest))

function removeDuplicatesFromSet

>	removeDuplicatesFromSet [] = []
>	removeDuplicatesFromSet (x:therest) =
>		x:(removeDuplicatesFromSet (removeXFromSet x therest))

function recursiveUnion

>	recursiveUnion l [] = l
>	recursiveUnion [] l = l
>	recursiveUnion (x:theRest) l = x:(recursiveUnion theRest l)

function union

>	union s t = removeDuplicatesFromSet (recursiveUnion s t)

function elementOf

>	elementOf x [] = False
>	elementOf x (y:theRest)
>	     | (x==y) = True
>	     | otherwise = (elementOf x theRest)

function subset

>	subset [] b = True
>	subset (x:theRest) b
>	     | (elementOf x b) = (subset theRest b)
>	     | otherwise = False

function setEquality

>	setEquality a b 
>	     | (subset a b) = (subset b a) 
>	     | otherwise = False

function differenceOf

>	differenceOf l [] = l
>	differenceOf [] l = []
>	differenceOf l (x:theRest) = 
>	     (differenceOf (removeXFromSet x l) theRest)

function intersectionOf

>	intersectionOf [] l = []
>	intersectionOf l [] = []
>	intersectionOf (x:theRest) l
>	     | (elementOf x l) = x:(intersectionOf theRest (removeXFromSet x l))
>	     | otherwise =(intersectionOf theRest l)

function symmetricDifferenceOf

>	symmetricDifferenceOf a b = union (differenceOf a b) (differenceOf b a)
