drop schema college;
create schema college;
use college;
Create Table Department (
	Name		VARCHAR(20),
	Location	VARCHAR(3),
	Primary Key(Name)
	) ENGINE=INNODB;


Create Table Student (
	ID		VARCHAR(10),
	Name		VARCHAR(20),
	Major		VARCHAR(20),
	Primary Key(ID),
	Foreign Key (Major) references Department(Name)
	)ENGINE=INNODB;

GRANT ALL ON college.* TO 'monty'@'%' IDENTIFIED BY 'foo' WITH GRANT OPTION;
