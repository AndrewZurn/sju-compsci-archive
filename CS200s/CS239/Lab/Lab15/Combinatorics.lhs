Problem 1: fact n = n!

>	fact n = if(n > 0) then n * fact (n-1) else 1

Problem 2a: c n k = number of k subsers of a set of size n = n!/k!/(n-k)!

>	choose n k = div (fact n) ((fact k) * (fact (n-k)))

Problem	2b: c2 n k (another way to compute c n k)

>	choose2 n 0 = 1
>	choose2 n k = if(n==k) then 1 else (choose2 (n-1) (k-1)) + (choose2 (n-1) k) 

Problem 3: f l where l is a list. First compute the sum of the numbers in l
    (n), then compute the product of the factorials of the numbers in l
    (n1!n2!...nk!), then f l = n!/that product = n!/(n1!n2!...nk!).

>	sumList []  = 0
>	sumList [n] = n
>	sumList (n : ns) = n + sumList ns;

>	factProduct [] = 0
>	factProduct [n] = fact (n)
>	factProduct (n : ns) = (fact (n)) * (factProduct (ns));

>	func l = div (fact (sumList l)) (factProduct l)
    
Problem 4: box n r = c (n+r-1) r

>	box n r = choose ((n+r)-1) r
