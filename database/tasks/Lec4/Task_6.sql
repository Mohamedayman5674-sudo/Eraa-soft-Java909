CREATE TABLE customers (
    full_name VARCHAR2(50)
);

INSERT INTO customers VALUES ('   Ahmed Ali   ');
INSERT INTO customers VALUES ('Sara Mohamed   ');
INSERT INTO customers VALUES ('   Omar Hassan');

SELECT TRIM(full_name) AS trimmed_name FROM customers;

SELECT LTRIM(full_name) AS left_trimmed FROM customers;

SELECT RTRIM(full_name) AS right_trimmed FROM customers;

SELECT TRIM('$' FROM '$$Ahmed Ali$$') AS cleaned_name FROM dual;	

SELECT REPLACE('promotion','o','O') AS RESULT FROM dual;

SELECT REPLACE('This is a basic course','basic','advanced') AS RESULT FROM dual;

SELECT
    LPAD(department_name, 15, '*') AS padded_left
FROM hr.departments;

SELECT RPAD(department_name,15,'*') AS  padded_right
FROM hr.departments;

SELECT TO_CHAR(SYSDATE ,'DD-MON-YYYY') AS RESULT FROM dual;

SELECT TO_CHAR(SYSDATE,'DAY-MONTH--YYYY') AS RESULT FROM dual;

SELECT TO_CHAR(1234567.89,'99,999,999.99') AS RESULT FROM dual;

SELECT TO_CHAR(5000,'$9,999.99') AS RESULT FROM dual;

SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS')
FROM dual;

SELECT name, marks,
CASE
    WHEN marks >= 90 THEN 'A'
    WHEN marks BETWEEN 80 AND 89 THEN 'B'
    WHEN marks BETWEEN 70 AND 79 THEN 'C'
    ELSE 'F'
END AS grade
FROM students;

SELECT name,marks,
CASE 
	WHEN marks >= 60 THEN 'Pass'
	ELSE 'Fail'
END AS RESULT
FROM students;

	SELECT  name, marks,
	CASE 
		WHEN marks >= 90 THEN 'Excellent'
		WHEN marks >= 80 THEN 'good'
		WHEN marks >= 70 THEN 'Average'
		ELSE 'Needs Improvement'
	END AS message
	FROM students;

SELECT 'Today is ' || TO_CHAR(SYSDATE, 'Day')
FROM dual;


SELECT marks,
DECODE(marks,
    100, 'A',
    90,  'B',
    80,  'C',
    'F'
) AS grade
FROM students;

CREATE TABLE status_log (
    status_code CHAR(1)
);

INSERT INTO status_log VALUES ('N');
INSERT INTO status_log VALUES ('I');
INSERT INTO status_log VALUES ('C');

SELECT status_code,
DECODE(status_code,
    'N', 'New',
    'I', 'In Progress',
    'C', 'Completed'
) AS status_desc
FROM status_log;

CREATE TABLE products (
    product_id NUMBER,
    quantity NUMBER
);

INSERT INTO products VALUES (1, 0);
INSERT INTO products VALUES (2, 10);
COMMIT;

SELECT quantity,
DECODE(quantity, 0, 'Out of Stock', 'Available')
FROM products;


SELECT department_id,
DECODE(department_id,
    'HR', 500,
    'IT', 1000,
    'Sales', 1500,
    300
) AS bonus
FROM employees;













