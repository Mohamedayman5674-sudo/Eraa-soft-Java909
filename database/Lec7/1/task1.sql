SELECT first_name, last_name, department_name
FROM employees
NATURAL JOIN departments;

CREATE TABLE customers_909 (
    customer_id NUMBER PRIMARY KEY,
    first_name  VARCHAR2(50),
    last_name   VARCHAR2(50)
);
CREATE TABLE orders_909 (
    order_id     NUMBER PRIMARY KEY,
    order_date   DATE,
    customer_id  NUMBER,
    CONSTRAINT fk_customer_909
    FOREIGN KEY (customer_id)
    REFERENCES customers_909(customer_id)
);


SELECT order_id,order_date,first_name,last_name
FROM orders_909
NATURAL JOIN customers_909;

CREATE TABLE students909 (
    student_id NUMBER PRIMARY KEY,
    student_name VARCHAR2(100)
);
CREATE TABLE courses909 (
    course_id NUMBER PRIMARY KEY,
    course_name VARCHAR2(100)
);
CREATE TABLE enrollments909 (
    student_id NUMBER,
    course_id  NUMBER,
    CONSTRAINT fk_student909 FOREIGN KEY (student_id)
        REFERENCES students909(student_id),
    CONSTRAINT fk_course909 FOREIGN KEY (course_id)
        REFERENCES courses909(course_id)
);


SELECT student_name,course_name
FROM students909
NATURAL JOIN enrollments909
NATURAL JOIN courses909;


CREATE TABLE employees909 (
    employee_id NUMBER PRIMARY KEY,
    employee_name VARCHAR2(100)
);

CREATE TABLE projects909 (
    project_id NUMBER PRIMARY KEY,
    project_name VARCHAR2(100)
);

CREATE TABLE project_assignments909 (
    employee_id NUMBER,
    project_id  NUMBER,
    CONSTRAINT fk_emp909 FOREIGN KEY (employee_id)
        REFERENCES employees909(employee_id),
    CONSTRAINT fk_proj909 FOREIGN KEY (project_id)
        REFERENCES projects909(project_id)
);


SELECT project_name,employee_name
FROM projects909
NATURAL JOIN project_assignments909
NATURAL JOIN employees909;


CREATE TABLE products909 (
    product_id NUMBER PRIMARY KEY,
    product_name VARCHAR2(100)
);
CREATE TABLE invoices909 (
    invoice_id NUMBER PRIMARY KEY,
    invoice_date DATE
);
CREATE TABLE invoice_items909 (
    invoice_id NUMBER,
    product_id NUMBER,
    quantity   NUMBER,
    CONSTRAINT fk_invoice909 FOREIGN KEY (invoice_id)
        REFERENCES invoices909(invoice_id),
    CONSTRAINT fk_product909 FOREIGN KEY (product_id)
        REFERENCES products909(product_id)
);


SELECT invoice_id,invoice_date,product_name,quantity
FROM invoices909
NATURAL JOIN invoice_items909
NATURAL JOIN products909;

CREATE TABLE authors909 (
    author_id NUMBER PRIMARY KEY,
    author_name VARCHAR2(100)
);
CREATE TABLE books909 (
    book_id NUMBER PRIMARY KEY,
    book_title VARCHAR2(100)
);
CREATE TABLE book_authors909 (
    book_id   NUMBER,
    author_id NUMBER,
    CONSTRAINT fk_book909 FOREIGN KEY (book_id)
        REFERENCES books909(book_id),
    CONSTRAINT fk_author909 FOREIGN KEY (author_id)
        REFERENCES authors909(author_id)
);
SELECT book_title, author_name
FROM books909
NATURAL JOIN book_authors909
NATURAL JOIN authors909;

CREATE TABLE instructors909 (
    instructor_id NUMBER PRIMARY KEY,
    instructor_name VARCHAR2(100)
);
CREATE TABLE classes909 (
    class_id NUMBER PRIMARY KEY,
    class_name VARCHAR2(100)
);
CREATE TABLE class_schedule909 (
    class_id      NUMBER,
    instructor_id NUMBER,
    schedule_time VARCHAR2(50),
    CONSTRAINT fk_class909 FOREIGN KEY (class_id)
        REFERENCES classes909(class_id),
    CONSTRAINT fk_instructor909 FOREIGN KEY (instructor_id)
        REFERENCES instructors909(instructor_id)
);


SELECT class_name,
       instructor_name,
       schedule_time
FROM classes909
NATURAL JOIN class_schedule909
NATURAL JOIN instructors909;

 CREATE TABLE suppliers909 (
    supplier_id NUMBER PRIMARY KEY,
    supplier_name VARCHAR2(100)
);
 CREATE TABLE products908 (
    product_id NUMBER PRIMARY KEY,
    product_name VARCHAR2(100)
);
 CREATE TABLE supplies909 (
    supplier_id NUMBER,
    product_id  NUMBER,
    CONSTRAINT fk_supplier909 FOREIGN KEY (supplier_id)
        REFERENCES suppliers909(supplier_id),
    CONSTRAINT fk_product908 FOREIGN KEY (product_id)
        REFERENCES products908(product_id)
);

 SELECT supplier_name,
       product_name
FROM suppliers909
NATURAL JOIN supplies909
NATURAL JOIN products908;

CREATE TABLE customers909 (
    customer_id NUMBER PRIMARY KEY,
    customer_name VARCHAR2(100)
);
CREATE TABLE orders909 (
    order_id NUMBER PRIMARY KEY,
    customer_id NUMBER,
    order_date DATE,
    CONSTRAINT fk_customer909 FOREIGN KEY (customer_id)
        REFERENCES customers909(customer_id)
);

CREATE TABLE shipping909 (
    order_id NUMBER,
    shipping_address VARCHAR2(200),
    shipping_date DATE,
    CONSTRAINT fk_order909 FOREIGN KEY (order_id)
        REFERENCES orders909(order_id)
);

SELECT customer_name,order_id,order_date,shipping_address,shipping_date
FROM customers909
NATURAL JOIN orders909
NATURAL JOIN shipping909;

CREATE TABLE jobs9092 (
    job_id NUMBER PRIMARY KEY,
    job_title VARCHAR2(100)
);
CREATE TABLE employees9092 (
    employee_id NUMBER PRIMARY KEY,
    employee_name VARCHAR2(100),
    job_id NUMBER,
    CONSTRAINT fk_job9092 FOREIGN KEY (job_id)
        REFERENCES jobs9092(job_id)
);

SELECT employee_name,
       job_title
FROM employees9092
NATURAL JOIN jobs9092;













