SELECT 
    e.first_name,
    d.department_name
FROM hr.employees e
LEFT JOIN hr.departments d
ON e.department_id = d.department_id;

SELECT 
    p.product_name,
    c.category_name
FROM products p
LEFT JOIN categories c
ON p.category_id = c.category_id;


SELECT 
    s.name AS student_name,
    c.course_name
FROM students s
LEFT JOIN enrollments e
ON s.student_id = e.student_id
LEFT JOIN courses c
ON e.course_id = c.course_id;

SELECT 
    o.order_id,
    c.customer_name
FROM orders o
LEFT JOIN customers c
ON o.customer_id = c.customer_id;

SELECT 
    d.department_name,
    e.first_name || ' ' || e.last_name AS manager_name
FROM hr.departments d
LEFT JOIN hr.employees e
ON d.manager_id = e.employee_id;

CREATE TABLE authors (
    author_id NUMBER PRIMARY KEY,
    author_name VARCHAR2(100) NOT NULL
);

SELECT 
    b.title,
    a.author_name
FROM books b
LEFT JOIN authors a
ON b.author_id = a.author_id;

CREATE TABLE invoices (
    invoice_id NUMBER PRIMARY KEY,
    invoice_date DATE,
    amount NUMBER(10,2)
);

CREATE TABLE payments (
    payment_id NUMBER PRIMARY KEY,
    invoice_id NUMBER,
    payment_status VARCHAR2(50),
    CONSTRAINT fk_invoice
        FOREIGN KEY (invoice_id)
        REFERENCES invoices(invoice_id)
);



SELECT 
    i.invoice_id,
    p.payment_status
FROM invoices i
LEFT JOIN payments p
ON i.invoice_id = p.invoice_id;


CREATE TABLE projects_assigned (
    employee_id NUMBER,
    project_id NUMBER,
    CONSTRAINT fk_emp
        FOREIGN KEY (employee_id)
        REFERENCES employees(employee_id),
    CONSTRAINT fk_proj
        FOREIGN KEY (project_id)
        REFERENCES projects(project_id)
);
SELECT 
    e.first_name,
    p.name
FROM employees e
LEFT JOIN projects_assigned pa
ON e.employee_id = pa.employee_id
LEFT JOIN projects p
ON pa.project_id = p.project_id;


