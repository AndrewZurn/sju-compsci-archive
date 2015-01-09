drop view IF EXISTS DEPT_8_EMP;
CREATE VIEW DEPT_8_EMP AS
	SELECT	SSN, FNAME,LNAME
	FROM 	employee
	WHERE 	DNO=8
WITH CHECK OPTION;
 -- with check options limits updates to base table tuples
 -- to tuples that satisfy the WHERE clause in the view definition