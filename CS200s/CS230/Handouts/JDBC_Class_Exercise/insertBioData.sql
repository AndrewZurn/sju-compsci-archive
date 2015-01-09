use bioDB;

Insert into Contributor Values('CSBSJU','Collegeville','MN','USA','0013203632837');
Insert into Contributor Values('U of M','Twin Cities','MN','USA','0016124432123');
Insert into Contributor Values('Gene Analyzer Lab','Tokyo','Tokyo','JAPAN','0810312341124');
Insert Into Contributor Values('Mayoclinic Labs','Rochster','MN','USA','0016123632837');
Insert Into Contributor Values('Cinco Labs','Mexico City',' ','Mexico',null);
Insert Into Contributor Values('Bayer','Munich',' ','Germany',null);
Insert Into Contributor Values('Mayoclinic Labs2','Austin','TX','USA',null);
Insert Into Contributor Values('Mitsu Labs','Tokyo',' ','Japan',null);
Insert Into Contributor Values('Big Pharma','Montreal','Quebec','Canada',null);


Insert into Gene Values('axin 1',null,'Human','GGGCCCGGGGTCCCGCCACCACCGCGCGCGGGACAGATTGATTCACTTTGGAGCTGTAAG','CSBSJU');
Insert into Gene Values('axin 2','Cardiology','Human','GGGCCCGGGACAGATTGGGGGGGCCCGCGCGCGTAAG','CSBSJU');
Insert into Gene Values('axin 3','Skin Formation','Human','ACATATATATTTATATATGGGG','U of M');
Insert into Gene Values('axin 4','Vision','Human','','Gene Analyzer Lab');
Insert Into Gene Values('Love Gene','Love','Human','ACTGCGTAAATATCCCCCCGCT','Mayoclinic Labs');
Insert Into Gene Values('Hair Gene','Hair','Human','ACTGCGTGGGGCT','Mayoclinic Labs2');
Insert Into Gene Values('Height Gene','Height','Human','ACCCCCCAAAAACGCT','Cinco Labs');
Insert Into Gene Values('Weight Gene','Weight','Human','CGTGCCCTCCCCCAATATCCCCCCGCT','Mayoclinic Labs');
Insert Into Gene Values('Smart Gene','Smartness','Human','ATCTACTACATACAATATCCCCCCGCT','Mitsu Labs');
Insert Into Gene Values('Dumb Gene','Dumbness','Human','ACTGGGGATATATATATA','Bayer');


Insert into Protein Values('semaphorin 6D','axin 1',null,'Human','GGGCCCGGGGTCCCGCCACCACCGCGCGCGGGACAGATTGATTCACTTTGGAGCTGTAAG','CSBSJU');
Insert into Protein Values('endoproteinase','axin 1',null,'Human','CLHHKAMLHMHKCGMHLLAK','U of M');
Insert into Protein Values('ribosome','axin 4','protein sythensis','Human','AGKCKCKLGKHHKCHHCMKMMKGLKLLCCAGGGMHMGCHAGKMMHHLGCMCCHAKCLAMA','Gene Analyzer Lab');
Insert Into Protein Values('Love Protein','Love Gene','Love','Human','CGGSLLNAN','Mayoclinic Labs');
Insert Into Protein Values('Strength Protein','Love Gene','Lov Strength','Human','TVLTAAHC','Mayoclinic Labs');
Insert Into Protein Values('Smart Protein','Smart Gene','Smartness','Human','CGGSLIRQG','Mayoclinic Labs');
Insert Into Protein Values('Smart Protein2','Smart Gene','More Smartness','Human','CGGSLIREDSSFVLTAAHC','Mayoclinic Labs');
Insert Into Protein Values('Smart Protein3','Smart Gene','Even More Smartness','Human','CGGSLIREDSS','Mayoclinic Labs');
Insert Into Protein Values('Dumb Protein2','Dumb Gene','Dumbness','Human','FVLTAAHC','Mayoclinic Labs');