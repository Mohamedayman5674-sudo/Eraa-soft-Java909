CREATE TABLE STUDENTS (
    name VARCHAR(50),
    marks INT
);

INSERT INTO STUDENTS (name, marks) VALUES ('Ahmed', 95);
INSERT INTO STUDENTS (name, marks) VALUES ('Sara', 85);
INSERT INTO STUDENTS (name, marks) VALUES ('Omar', 75);
INSERT INTO STUDENTS (name, marks) VALUES ('Laila', 65);
INSERT INTO STUDENTS (name, marks) VALUES ('Youssef', 88);

SELECT 
    name,
    marks,
    CASE
        WHEN marks >= 90 THEN 'A'
        WHEN marks BETWEEN 80 AND 89 THEN 'B'
        WHEN marks BETWEEN 70 AND 79 THEN 'C'
        ELSE 'F'
    END AS grade
FROM STUDENTS;



