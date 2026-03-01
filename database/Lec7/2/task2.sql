SELECT 
    d.department_name,
    e.first_name
FROM hr.employees e
RIGHT JOIN hr.departments d
ON e.department_id = d.department_id;

SELECT 
    o.order_id,
    c.customer_name
FROM orders o
RIGHT JOIN customers c
ON o.customer_id = c.customer_id;

SELECT 
    c.course_name,
    s.name AS student_name
FROM enrollments e
RIGHT JOIN courses c
ON e.course_id = c.course_id
LEFT JOIN students s
ON e.student_id = s.student_id;

SELECT 
    p.name,
    e.first_name
FROM projects_assigned pa
RIGHT JOIN projects p
ON pa.project_id = p.project_id
LEFT JOIN employees e
ON pa.employee_id = e.employee_id;

CREATE TABLE payment_methods (
    method_id NUMBER PRIMARY KEY,
    method_name VARCHAR2(100) NOT NULL
);
CREATE TABLE transactions (
    transaction_id NUMBER PRIMARY KEY,
    transaction_date DATE,
    method_id NUMBER,
    CONSTRAINT fk_payment_method
        FOREIGN KEY (method_id)
        REFERENCES payment_methods(method_id)
);


SELECT 
    pm.method_name,
    t.transaction_id
FROM transactions t
RIGHT JOIN payment_methods pm
ON t.method_id = pm.method_id;

SELECT 
    a.author_name,
    b.title
FROM books b
RIGHT JOIN authors a
ON b.author_id = a.author_id;

SELECT 
    c.category_name,
    p.product_name
FROM products p
RIGHT JOIN categories c
ON p.category_id = c.category_id;


SELECT 
    d.room_number,
    s.name AS student_name
FROM students s
RIGHT JOIN dorm_rooms d
ON s.room_id = d.room_id;









