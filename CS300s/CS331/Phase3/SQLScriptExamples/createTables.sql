-- used to specify comments in sql scripts

DROP SCHEMA IF EXISTS Company;
-- Create the database
CREATE SCHEMA IF NOT EXISTS Company;

-- use the created database henceforth
use Company;

-- EMPLOYEE
CREATE TABLE IF NOT EXISTS employee (
  fname    varchar(15) not null, 
  minit    varchar(1),
  lname    varchar(15) not null,
  ssn      char(9),
  bdate    date,
  address  varchar(50),
  sex      char check (sex  in ('M','F')),
  salary   decimal(10,2),
  superssn char(9),
  dno      integer(4),
  primary key (ssn)
)ENGINE=InnoDB;

-- DEPARTMENT
CREATE TABLE IF NOT EXISTS department (
  dname        varchar(25) not null,
  dnumber      integer(4),
  mgrssn       char(9) not null, 
  mgrstartdate date,
  primary key (dnumber),
  key (dname),
  foreign key (mgrssn) references employee(ssn)
) ENGINE=InnoDB;

-- ADD FOREIGN KEY CONSTRAINST TO EMPLOYEE: superssn references ssn and dno references dnumber
Alter Table employee ADD CONSTRAINT FK1 foreign key (superssn) references employee(ssn);
Alter Table employee ADD CONSTRAINT FK2 foreign key (dno) references department(dnumber);

-- DEPENDENT
CREATE TABLE IF NOT EXISTS dependent (
  essn           char(9),
  dependent_name varchar(15),
  sex            char,
  bdate          date,
  relationship   varchar(8),
  primary key (essn,dependent_name),
  foreign key (essn) references employee(ssn)
)ENGINE=InnoDB;

-- DEPT_LOCATIONS
CREATE TABLE IF NOT EXISTS dept_locations (
  dnumber   integer(4),
  dlocation varchar(15), 
  primary key (dnumber,dlocation),
  foreign key (dnumber) references department(dnumber)
)ENGINE=InnoDB;

-- PROJECT
CREATE TABLE IF NOT EXISTS project (
  pname      varchar(25) not null,
  pnumber    integer(4),
  plocation  varchar(15),
  dnum       integer(4),
  primary key (pnumber),
  unique (pname),
  foreign key (dnum) references department(dnumber)
)Engine=InnoDB;

-- WORKS_ON
CREATE TABLE IF NOT EXISTS works_on (
  essn   char(9),
  pno    integer(4),
  hours  decimal(4,1),
  primary key (essn,pno),
  foreign key (essn) references employee(ssn),
  foreign key (pno) references project(pnumber)
)ENGINE=InnoDB;

GRANT ALL ON Company.* TO monty@'%' IDENTIFIED BY 'foo' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO monty@'%' IDENTIFIED BY 'foo' WITH GRANT OPTION;

GRANT ALL ON Company.* TO KKutzke@'%' IDENTIFIED BY 'KKutzke' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO KKutzke@'%' IDENTIFIED BY 'KKutzke' WITH GRANT OPTION;

GRANT ALL ON Company.* TO JSpringer@'%' IDENTIFIED BY 'JSpringer' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO JSpringer@'%' IDENTIFIED BY 'JSpringer' WITH GRANT OPTION;

GRANT ALL ON Company.* TO TXiong@'%' IDENTIFIED BY 'TXiong' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO TXiong@'%' IDENTIFIED BY 'TXiong' WITH GRANT OPTION;

GRANT ALL ON Company.* TO PNowak@'%' IDENTIFIED BY 'PNowak' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO PNowak@'%' IDENTIFIED BY 'PNowak' WITH GRANT OPTION;


GRANT ALL ON Company.* TO TOlson@'%' IDENTIFIED BY 'TOlson' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO TOlson@'%' IDENTIFIED BY 'TOlson' WITH GRANT OPTION;

GRANT ALL ON Company.* TO ARahman@'%' IDENTIFIED BY 'ARahman' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO ARahman@'%' IDENTIFIED BY 'ARahman' WITH GRANT OPTION;

GRANT ALL ON Company.* TO HTebeka@'%' IDENTIFIED BY 'HTebeka' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO HTebeka@'%' IDENTIFIED BY 'HTebeka' WITH GRANT OPTION;

GRANT ALL ON Company.* TO QVuong@'%' IDENTIFIED BY 'QVuong' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO QVuong@'%' IDENTIFIED BY 'QVuong' WITH GRANT OPTION;

GRANT ALL ON Company.* TO MScherber@'%' IDENTIFIED BY 'MScherber' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO MScherber@'%' IDENTIFIED BY 'MScherber' WITH GRANT OPTION;

GRANT ALL ON Company.* TO MSchoenberg@'%' IDENTIFIED BY 'MSchoenberg' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO MSchoenberg@'%' IDENTIFIED BY 'MSchoenberg' WITH GRANT OPTION;

GRANT ALL ON Company.* TO AZurn@'%' IDENTIFIED BY 'AZurn' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO AZurn@'%' IDENTIFIED BY 'AZurn' WITH GRANT OPTION;

GRANT ALL ON Company.* TO DWee@'%' IDENTIFIED BY 'DWee' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO DWee@'%' IDENTIFIED BY 'DWee' WITH GRANT OPTION;

GRANT ALL ON Company.* TO TAnderson@'%' IDENTIFIED BY 'TAnderson' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO TAnderson@'%' IDENTIFIED BY 'TAnderson' WITH GRANT OPTION;

GRANT ALL ON Company.* TO AHonzay@'%' IDENTIFIED BY 'AHonzay' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO AHonzay@'%' IDENTIFIED BY 'AHonzay' WITH GRANT OPTION;

GRANT ALL ON Company.* TO ARiedeman@'%' IDENTIFIED BY 'ARiedeman' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO ARiedeman@'%' IDENTIFIED BY 'ARiedeman' WITH GRANT OPTION;

GRANT ALL ON Company.* TO JLarson@'%' IDENTIFIED BY 'JLarson' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO JLarson@'%' IDENTIFIED BY 'JLarson' WITH GRANT OPTION;

GRANT ALL ON Company.* TO MLee@'%' IDENTIFIED BY 'MLee' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO MLee@'%' IDENTIFIED BY 'MLee' WITH GRANT OPTION;

GRANT ALL ON Company.* TO RMord@'%' IDENTIFIED BY 'RMord' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO RMord@'%' IDENTIFIED BY 'RMord' WITH GRANT OPTION;

GRANT ALL ON Company.* TO YThao@'%' IDENTIFIED BY 'YThao' WITH GRANT OPTION;
GRANT SELECT ON mysql.proc TO YThao@'%' IDENTIFIED BY 'YThao' WITH GRANT OPTION;