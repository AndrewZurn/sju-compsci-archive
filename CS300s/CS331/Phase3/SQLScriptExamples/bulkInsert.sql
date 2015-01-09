CREATE TABLE  DEPTS_INFO (
	DEPT_NUM	INT(4),
	DEPT_NAME	VARCHAR(10),
	NO_OF_EMPS	INTEGER,
	TOTAL_SAL	INTEGER
	);
	
INSERT INTO DEPTS_INFO (DEPT_NUM, DEPT_NAME, NO_OF_EMPS, TOTAL_SAL)(
	SELECT	dnumber,dname, count(*), sum(salary)
	FROM		department, employee
	WHERE		dnumber=dno
	GROUP BY	dnumber,dname);
