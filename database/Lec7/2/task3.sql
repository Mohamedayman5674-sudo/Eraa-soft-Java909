SELECT 
    c.customer_name,
    o.order_id
FROM customers c
FULL OUTER JOIN orders o
ON c.customer_id = o.customer_id;


SELECT 
    e.FIRST_NAME,
    p.name
FROM employees e
FULL OUTER JOIN projects_assigned pa
ON e.employee_id = pa.employee_id
FULL OUTER JOIN projects p
ON pa.project_id = p.project_id;

SELECT 
    p.product_name,
    s.supplier_name
FROM products p
FULL OUTER JOIN suppliers s
ON p.supplier_id = s.supplier_id;

SELECT 
    s.name,
    c.course_name
FROM students s
FULL OUTER JOIN enrollments e
ON s.student_id = e.student_id
FULL OUTER JOIN courses c
ON e.course_id = c.course_id;

SELECT 
    a.author_name,
    b.title
FROM authors a
FULL OUTER JOIN books b
ON a.author_id = b.author_id;

SELECT 
    e.first_name,
    d.department_name
FROM hr.employees e
FULL OUTER JOIN hr.departments d
ON e.department_id = d.department_id;

SELECT 
    t.transaction_id,
    pm.method_name
FROM transactions t
FULL OUTER JOIN payment_methods pm
ON t.method_id = pm.method_id;

CREATE TABLE customers_region1 (
    customer_id NUMBER,
    name VARCHAR2(100)
);

CREATE TABLE customers_region2 (
    customer_id NUMBER,
    name VARCHAR2(100)
);



SELECT * FROM customers_region1
FULL OUTER JOIN customers_region2
ON customers_region1.customer_id = customers_region2.customer_id;








