
CREATE TABLE Piayer( 
id NUMBER NOT NULL ,
name VARCHAR2(50) UNIQUE,
age NUMBER,
UNIQUE(id)
);

CREATE TABLE Manger (
    id NUMBER NOT NULL,
    name VARCHAR(100),
    salary DECIMAL(10,2),
    UNIQUE (id, name)
);

CREATE TABLE Manger_PK (
    id NUMBER NOT NULL,
    name VARCHAR(100),
    age NUMBER,
    PRIMARY KEY (id)
);






