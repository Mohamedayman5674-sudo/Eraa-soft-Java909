SELECT 
    name,
    marks,
    DECODE(
        FLOOR(marks / 10),
        10, 'A',
        9,  'A',
        8,  'B',
        7,  'C',
        'F'
    ) AS grade
FROM STUDENTS;

CREATE TABLE ORDERS (
    status CHAR(1)
);

INSERT INTO ORDERS (status) VALUES ('P');
INSERT INTO ORDERS (status) VALUES ('S');
INSERT INTO ORDERS (status) VALUES ('D');

SELECT 
    status,
    DECODE(
        status,
        'P', 'Pending',
        'S', 'Shipped',
        'D', 'Delivered',
        'Unknown'
    ) AS status_description
FROM ORDERS;



