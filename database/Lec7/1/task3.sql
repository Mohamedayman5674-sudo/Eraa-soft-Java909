SELECT 
    e.first_name || ' ' || e.last_name AS employee_name,
    m.first_name || ' ' || m.last_name AS manager_name
FROM hr.employees e
LEFT JOIN hr.employees m
ON e.manager_id = m.employee_id;

SELECT 
    e.first_name AS salesperson_name,
    e2.first_name AS customer_name
FROM hr.employees e
JOIN hr.employees e2
ON e.employee_id = e2.manager_id;

CREATE TABLE orders (
    order_id NUMBER PRIMARY KEY,
    order_date DATE,
    customer_name VARCHAR2(100)
);
CREATE TABLE order_details (
    order_id NUMBER,
    product_id NUMBER,
    quantity NUMBER,
    CONSTRAINT fk_order
        FOREIGN KEY (order_id)
        REFERENCES orders(order_id)
);


SELECT o.order_id,
       od.product_id,
       od.quantity
FROM orders o
JOIN order_details od
ON o.order_id = od.order_id;


CREATE TABLE instructors (
    instructor_id NUMBER PRIMARY KEY,
    name VARCHAR2(100)
);

CREATE TABLE students (
    student_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    instructor_id NUMBER,
    CONSTRAINT fk_instructor
        FOREIGN KEY (instructor_id)
        REFERENCES instructors(instructor_id)
);

SELECT s.name AS student_name,
       i.name AS instructor_name
FROM students s
JOIN instructors i
ON s.instructor_id = i.instructor_id;

SELECT 
    e.salary,
    d.department_name
FROM hr.employees e
JOIN hr.departments d
ON e.department_id = d.department_id;

CREATE TABLE projects (
    project_id NUMBER PRIMARY KEY,
    name VARCHAR2(100)
);

CREATE TABLE tasks (
    task_id NUMBER PRIMARY KEY,
    name VARCHAR2(100),
    project_id NUMBER,
    CONSTRAINT fk_project
        FOREIGN KEY (project_id)
        REFERENCES projects(project_id)
);


SELECT 
    p.name AS project_name,
    t.name AS task_name
FROM projects p
JOIN tasks t
ON p.project_id = t.project_id;

CREATE TABLE courses (
    course_id NUMBER PRIMARY KEY,
    course_name VARCHAR2(100) NOT NULL
);
CREATE TABLE exams (
    exam_id NUMBER PRIMARY KEY,
    exam_date DATE,
    course_id NUMBER,
    CONSTRAINT fk_course_exam
        FOREIGN KEY (course_id)
        REFERENCES courses(course_id)
);


SELECT 
    c.course_name,
    e.exam_date
FROM courses c
JOIN exams e
ON c.course_id = e.course_id;

CREATE TABLE categories (
    category_id NUMBER PRIMARY KEY,
    category_name VARCHAR2(100) NOT NULL
);

CREATE TABLE products (
    product_id NUMBER PRIMARY KEY,
    product_name VARCHAR2(100) NOT NULL,
    category_id NUMBER,
    CONSTRAINT fk_category
        FOREIGN KEY (category_id)
        REFERENCES categories(category_id)
);


SELECT 
    p.product_name,
    c.category_name
FROM products p
JOIN categories c
ON p.category_id = c.category_id;

CREATE TABLE publishers (
    publisher_id NUMBER PRIMARY KEY,
    publisher_name VARCHAR2(100) NOT NULL
);
CREATE TABLE books (
    book_id NUMBER PRIMARY KEY,
    title VARCHAR2(150) NOT NULL,
    publisher_id NUMBER,
    CONSTRAINT fk_publisher
        FOREIGN KEY (publisher_id)
        REFERENCES publishers(publisher_id)
);


SELECT 
    b.title,
    p.publisher_name
FROM books b
JOIN publishers p
ON b.publisher_id = p.publisher_id;


SELECT 
    e.first_name,
    d.location_id
FROM hr.employees e
JOIN hr.departments d
ON e.department_id = d.department_id;

