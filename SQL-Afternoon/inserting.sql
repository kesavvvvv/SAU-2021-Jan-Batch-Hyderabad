create table PRODUCTS(PCODE INT NOT NULL, 
PNAME VARCHAR(50), 
UNIT_PRICE DECIMAL NOT NULL, 
CCODE INT NOT NULL, 
primary key(PCODE));

create table CATEGORY(CCODE INT NOT NULL, 
CNAME VARCHAR(50) NOT NULL, 
primary key(CCODE));

create table CUSTOMER(CUID INT NOT NULL, 
CUNAME VARCHAR(50) NOT NULL, 
DOB DATE NOT NULL, 
GENDER CHAR(1) NOT NULL, 
CONSTRAINT CHECK(GENDER IN ('M', 'F')),
MOBILE_NO VARCHAR(21) NOT NULL, 
LCODE INT NOT NULL, 
primary key(CUID));

ALTER TABLE CUSTOMER MODIFY MOBILE_NO VARCHAR(12);

create table LOCATION(
LCODE INT NOT NULL, 
LNAME VARCHAR(50) NOT NULL, 
primary key(LCODE));

create table SALES_EXEC(
SEID INT NOT NULL,
SENAME VARCHAR(50) NOT NULL, 
DOB DATE NOT NULL, 
GENDER CHAR(1) NOT NULL,
constraint CHECK (GENDER IN ('M', 'F')),
MOBILE_NO VARCHAR(12) NOT NULL, 
primary key(SEID));

CREATE TABLE PURCHASE(
SEID INT NOT NULL,
PCODE INT NOT NULL,
CUID INT NOT NULL,
DOP DATE NOT NULL,
NOU INT NOT NULL,
primary key(SEID,PCODE,CUID,DOP));

ALTER TABLE PRODUCTS ADD FOREIGN KEY (CCODE) REFERENCES CATEGORY(CCODE);
ALTER TABLE CUSTOMER ADD FOREIGN KEY (LCODE) REFERENCES LOCATION(LCODE);
ALTER TABLE PURCHASE ADD FOREIGN KEY (SEID) REFERENCES SALES_EXEC(SEID);
ALTER TABLE PURCHASE ADD FOREIGN KEY (PCODE) REFERENCES PRODUCTS(PCODE);
ALTER TABLE PURCHASE ADD FOREIGN KEY (CUID) REFERENCES CUSTOMER(CUID);

INSERT INTO CATEGORY VALUES(1,"CPU");
INSERT INTO CATEGORY VALUES(2,"MOTHERBOARD");
INSERT INTO CATEGORY VALUES(3,"RAM");
INSERT INTO CATEGORY VALUES(4,"CASE");
INSERT INTO CATEGORY VALUES(5,"GPU");

SELECT * FROM CATEGORY;

INSERT INTO PRODUCTS VALUES(101,"INTEL I9 10900K", 550, 1);
INSERT INTO PRODUCTS VALUES(102,"AMD RYZEN 9 5950X", 450, 1);
INSERT INTO PRODUCTS VALUES(201,"ASUS ROG STRIX Z490-G", 450, 2);
INSERT INTO PRODUCTS VALUES(202,"ASUS ROG Strix X570-E", 350, 2);
INSERT INTO PRODUCTS VALUES(301,"Corsair Vengeance RGB Pro 32GB, 3600MHz", 275, 3);
INSERT INTO PRODUCTS VALUES(302,"Crucial Ballistix RGB 32GB, 3600MHz", 250, 3);
INSERT INTO PRODUCTS VALUES(401,"NZXT H510 ELITE", 220, 4);
INSERT INTO PRODUCTS VALUES(402,"LIAN LI PC-O11DW", 350, 4);
INSERT INTO PRODUCTS VALUES(501,"NVIDIA GEFORCE RTX 3090", 1500, 5);
INSERT INTO PRODUCTS VALUES(502,"AMD RADEON RX 6900XT", 999, 5);

SELECT * FROM PRODUCTS;

INSERT INTO LOCATION VALUES(601, 'KK NAGAR');
INSERT INTO LOCATION VALUES(602, 'VADAPALANI');
INSERT INTO LOCATION VALUES(603, 'VIRUGAMBAKKAM');

SELECT * FROM LOCATION;

INSERT INTO CUSTOMER VALUES(901, "KESAV", '1999-09-21','M', '987654321', 603);
INSERT INTO CUSTOMER VALUES(902, "ANAM", '1999-11-19', 'M', '9176254462', 601);
INSERT INTO CUSTOMER VALUES(903, "SAI", '1998-03-01', 'M', '9962554412', 602);
INSERT INTO CUSTOMER VALUES(904, "NAVEEN", '1999-12-25', 'M', '8939244312', 603);
INSERT INTO CUSTOMER VALUES(905, "NEELESH", '1999-11-21', 'M', '9884431281', 602);

SELECT * FROM CUSTOMER;

INSERT INTO SALES_EXEC VALUES(5001, "PREM",'1999-03-12', 'M', '9841275333');
INSERT INTO SALES_EXEC VALUES(5002, "NISHANT",'1999-10-15', 'M', '9841275332');
INSERT INTO SALES_EXEC VALUES(5003, "RAHUL",'1999-01-16', 'M', '9841275331');

SELECT * FROM SALES_EXEC;

INSERT INTO PURCHASE VALUES(5001, 101, 902, '2021-01-10', 1);
INSERT INTO PURCHASE VALUES(5001, 102, 901, '2021-01-10', 1);
INSERT INTO PURCHASE VALUES(5001, 101, 904, '2021-01-10', 1);
INSERT INTO PURCHASE VALUES(5002, 201, 902, '2021-01-10', 1);
INSERT INTO PURCHASE VALUES(5002, 202, 901, '2021-01-10', 1);
INSERT INTO PURCHASE VALUES(5002, 201, 904, '2021-01-10', 1);
INSERT INTO PURCHASE VALUES(5003, 501, 901, '2021-01-10', 2);
INSERT INTO PURCHASE VALUES(5003, 401, 901, '2021-01-10', 1);
INSERT INTO PURCHASE VALUES(5003, 302, 903, '2021-01-10', 2);
INSERT INTO PURCHASE VALUES(5001, 102, 905, '2021-01-10', 1);
INSERT INTO PURCHASE VALUES(5002, 202, 905, '2021-01-10', 1);

SELECT * FROM PURCHASE;