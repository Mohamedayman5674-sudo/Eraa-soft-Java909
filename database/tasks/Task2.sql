CREATE TABLE Doctor(
id  NUMBER,
name VARCHAR2(150),
salary   number(10,2),
address  VARCHAR2(200)
);

INSERT INTO DOCTOR VALUES(1,'mohamed',   6000,'alex');
INSERT INTO DOCTOR VALUES(2,'ahmed',     5000,'cairo');
INSERT INTO DOCTOR VALUES (3, 'ali',     4500, 'giza');
INSERT INTO DOCTOR VALUES (4, 'mostafa', 7000, 'mansoura');
INSERT INTO DOCTOR VALUES (5, 'omar',    6500, 'tanta');
INSERT INTO DOCTOR VALUES (6, 'youssef', 4800, 'aswan');
INSERT INTO DOCTOR VALUES (7, 'khaled',  5200, 'fayoum');
INSERT INTO DOCTOR VALUES (8, 'mahmoud', 8000, 'alex');
INSERT INTO DOCTOR VALUES (9, 'hassan',  5500, 'sohag');
INSERT INTO DOCTOR VALUES (10,'ibrahim', 9000, 'cairo');

UPDATE DOCTOR 
SET salary=20000
WHERE id=3;


DELETE DOCTOR 
WHERE id=9 ;


SELECT 

name||'-'||salary AS name_salary

FROM DOCTOR;


SELECT 
id,
name,
salary  * 2 AS salary_double,
address
FROM DOCTOR ;




SELECT * FROM DOCTOR WHERE SALARY IN (4500,4800,5200) ; 



ALTER TABLE DOCTOR 
RENAME TO PRD_DOCTOR;

