-- Query 1
SELECT 	'Query 1', E.fname, E.lname, S.fname, S.lname 
FROM 	(employee E JOIN employee S ON E.superssn=S.ssn);

-- Query 2
SELECT 	'Query 2', E.fname, E.lname, S.fname, S.lname 
FROM 	(employee E JOIN employee S)
WHERE  	E.superssn=S.ssn;

-- Query 3
SELECT	'Query 3', fname, lname, address
FROM 	employee
WHERE	dno IN  (SELECT	dnumber	  
 				 FROM	department
 				 WHERE 	dname='Research' );
-- Query 4
SELECT 	'Query 4', lname
FROM	employee
WHERE   NOT EXISTS (	SELECT 	*  
		    		FROM		project  
		    		WHERE 	dnum=1 AND NOT EXISTS (
					SELECT	*
	 				FROM     	works_on WO
			 		WHERE 	ssn=WO.essn AND 
							WO.pno=pnumber));
