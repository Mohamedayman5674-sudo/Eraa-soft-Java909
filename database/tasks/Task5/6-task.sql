CREATE TABLE Language (
    id NUMBER PRIMARY KEY,
    name VARCHAR(100) NOT NULL
);

CREATE TABLE Teacher (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary DECIMAL(10,2),
    language_id NUMBER NOT NULL,
    CONSTRAINT language_id_fk FOREIGN KEY (language_id) REFERENCES Language(id)
);












  