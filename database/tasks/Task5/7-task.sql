
CREATE TABLE Employee_909 (
id NUMBER  PRIMARY KEY,
name VARCHAR2(50) NOT NULL,
age INT NOT NULL	
);

CREATE TABLE Phone_909(
id INT PRIMARY KEY,
phoneNumber VARCHAR2(20),
 employee_id NUMBER UNIQUE NOT NULL ,
    CONSTRAINT employee_id_fk FOREIGN KEY (employee_id) REFERENCES Employee_909(id)
);