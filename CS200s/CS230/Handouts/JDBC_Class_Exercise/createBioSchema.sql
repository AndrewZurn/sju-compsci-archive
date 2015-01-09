drop schema bioDB;
create schema bioDB;
use bioDB;
Create Table Contributor (
	LabName	VARCHAR(30),
	City		VARCHAR(20),
	State	VARCHAR(20),
	Country	VARCHAR(20),
	Contact	VARCHAR(15),
	Primary Key (LabName)
)ENGINE=INNODB;

Create Table Gene (
	GeneName		VARCHAR(20),
	GFunction		VARCHAR(20),
	GOrganism		VARCHAR(20),
	GSequence		VARCHAR(250),
	GContributor	VARCHAR(30),
	Primary Key (GeneName),
	Foreign Key (GContributor) References Contributor(LabName)
)ENGINE=INNODB;

Create Table Protein (
	ProteinName	VARCHAR(20),
	Gene			VARCHAR(20),
	PFunction		VARCHAR(20),
	POrganism		VARCHAR(20),
	PSequence		VARCHAR(250),
	PContributor	VARCHAR(30),
	Primary Key (ProteinName),
	Foreign Key (PContributor) References Contributor (LabName),
     Foreign Key (Gene) References Gene(GeneName)
)ENGINE=INNODB;

GRANT ALL ON bioDB.* TO 'monty'@'%' IDENTIFIED BY 'foo' WITH GRANT OPTION;