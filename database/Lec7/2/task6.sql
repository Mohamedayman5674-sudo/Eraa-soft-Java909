SELECT *
FROM employees
WHERE salary > ANY (
    SELECT salary
    FROM employees
    WHERE department_id = 10
);

SELECT *
FROM employees
WHERE salary < ALL (
    SELECT salary
    FROM employees
    WHERE department_id = 20
);

SELECT *
FROM products
WHERE price IN (
    SELECT price
    FROM products
    WHERE category = 'Electronics'
);

SELECT c.customer_name
FROM customers c
WHERE c.customer_id IN (
    SELECT o.customer_id
    FROM orders o
    JOIN order_items oi ON o.order_id = oi.order_id
    WHERE oi.price > 1000
);

SELECT *
FROM employees e
WHERE job_id IN (
    SELECT job_id
    FROM employees
    GROUP BY job_id
    HAVING COUNT(*) > 1
);

SELECT department_id
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 1;

SELECT *
FROM orders o
WHERE o.customer_id IN (
    SELECT c.customer_id
    FROM customers c
    WHERE c.city IN (
        SELECT city
        FROM customers
        GROUP BY city
        HAVING COUNT(*) > 1
    )
);

SELECT *
FROM books
WHERE author_id IN (
    SELECT author_id
    FROM books
    GROUP BY author_id
    HAVING COUNT(*) > 1
);

SELECT name
FROM students
WHERE course_id IN (
    SELECT course_id
    FROM courses
    WHERE professor_name = 'Dr. Smith'
);

SELECT *
FROM employees
WHERE salary IN (
    SELECT salary
    FROM employees
    WHERE department_id = 30
);