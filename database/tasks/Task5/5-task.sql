CREATE TABLE Doctor (
    id NUMBER PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    salary DECIMAL(10,2)
);

CREATE TABLE Patient (
    id NUMBER PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age NUMBER
);	

CREATE TABLE Doctor_Patient(
Doctor_id NUMBER NOT NULL,
Patient_id NUMBER NOT NULL,
   CONSTRAINT Doctor_id_fk FOREIGN KEY (Doctor_id) REFERENCES Doctor(id),
     CONSTRAINT Patient_id_fk FOREIGN KEY (Patient_id) REFERENCES Patient(id),
     UNIQUE (Doctor_id,Patient_id)
);
