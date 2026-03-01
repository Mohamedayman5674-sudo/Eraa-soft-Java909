SELECT first_name, salary
FROM hr.employees
WHERE salary > (
    SELECT AVG(salary)
    FROM hr.employees
);

SELECT customer_id
FROM orders
GROUP BY customer_id
HAVING COUNT(*) = (
    SELECT MAX(order_count)
    FROM (
        SELECT COUNT(*) order_count
        FROM orders
        GROUP BY customer_id
    )
);


SELECT product_name, price
FROM products
WHERE price > ANY (
    SELECT price
    FROM products
    WHERE category_id = (
        SELECT category_id
        FROM categories
        WHERE category_name = 'Accessories'
    )
);

SELECT first_name, last_name
FROM hr.employees
WHERE department_id = (
    SELECT department_id
    FROM hr.employees
    WHERE first_name = 'John'
    AND last_name = 'Smith'
);

SELECT *
FROM orders
WHERE customer_id IN (
    SELECT customer_id
    FROM customers
    WHERE city = 'New York'
);

SELECT department_name
FROM hr.departments d
WHERE NOT EXISTS (
    SELECT 1
    FROM hr.employees e
    WHERE e.department_id = d.department_id
);

SELECT name
FROM students s
WHERE NOT EXISTS (
    SELECT 1
    FROM enrollments e
    WHERE e.student_id = s.student_id
);

SELECT MAX(salary)
FROM hr.employees
WHERE salary < (
    SELECT MAX(salary)
    FROM hr.employees
);

SELECT product_name, price
FROM products
WHERE price > (
    SELECT AVG(price)
    FROM products
);

SELECT c.customer_id
FROM customers c
WHERE NOT EXISTS (
    SELECT 1
    FROM products p
    WHERE p.category_id = (
        SELECT category_id
        FROM categories
        WHERE category_name = 'A'
    )
    AND NOT EXISTS (
        SELECT 1
        FROM order_details od
        JOIN orders o
        ON od.order_id = o.order_id
        WHERE o.customer_id = c.customer_id
        AND od.product_id = p.product_id
    )
); 	


