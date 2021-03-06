CREATE TABLE "STUDENT" (
    "ID" VARCHAR(32) not null primary key,
    "FIRSTNAME" VARCHAR(30),
    "LASTNAME" VARCHAR(30),
    "BIRTHDATE" DATE,
    "PHONE" VARCHAR(10),
    "EMAIL" VARCHAR(60),
    "DEPARTID" VARCHAR(15)
);

INSERT INTO USERAPP.STUDENT (ID, FIRSTNAME, LASTNAME, BIRTHDATE, PHONE, EMAIL, DEPARTID) 
	VALUES ('7315489', 'Bernard', 'SOYER', '2013-07-15', '9658421', 'bsoyer@hotmail.com', 'GI');
INSERT INTO USERAPP.STUDENT (ID, FIRSTNAME, LASTNAME, BIRTHDATE, PHONE, EMAIL, DEPARTID) 
	VALUES ('8964723', 'Betoszos', 'LASCARIS', '2013-07-18', '96842347', 'lascaris@yahoo.fr', 'GE');


CREATE TABLE "DEPARTMENT" (
    "ID" VARCHAR(32) not null primary key,
    "NAME" VARCHAR(30),
    "NBRLEVEL" INTEGER,
    "PHONE" VARCHAR(10)
);

INSERT INTO USERAPP.DEPARTMENT (ID, NAME, NBRLEVEL, PHONE) 
	VALUES ('GI', 'Computer Engineering', 10,  '9958321');


CREATE TABLE "PERSON" (
    "ID" VARCHAR(32) not null primary key,
    "FIRSTNAME" VARCHAR(30),
    "LASTNAME" VARCHAR(30),
    "USERLOGIN" VARCHAR(10),
    "USERROLE" VARCHAR(10),
    "TYPE" VARCHAR(30)
);

INSERT INTO USERAPP.PERSON (ID, FIRSTNAME, LASTNAME, USERLOGIN,USERROLE,TYPE) 
	VALUES ('PS8613079', 'Adwin', 'LEWIS CLEF',  'adwiner','ADMIN','APPUSER');

INSERT INTO USERAPP.PERSON (ID, FIRSTNAME, LASTNAME, USERLOGIN,USERROLE,TYPE) 
	VALUES ('PS1613379', 'Edmon', 'BERTOS LU',  'ebertos','FDK','APPUSER');
