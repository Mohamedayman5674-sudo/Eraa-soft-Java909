SELECT first_name, salary
FROM hr.employees
WHERE salary = (
    SELECT MAX(salary)
    FROM hr.employees
);

SELECT first_name
FROM hr.employees
WHERE department_id = (
    SELECT department_id
    FROM hr.employees
    WHERE first_name = 'Alice'
);

SELECT *
FROM products
WHERE product_price = (
    SELECT MIN(product_price)
    FROM products
);

SELECT department_name
FROM hr.departments
WHERE department_id = (
    SELECT department_id
    FROM hr.employees
    WHERE salary = (
        SELECT MAX(salary)
        FROM hr.employees
    )
);

SELECT manager_id
FROM hr.employees
WHERE employee_id = (
    SELECT employee_id
    FROM hr.employees
    WHERE hire_date = (
        SELECT MAX(hire_date)
        FROM hr.employees
    )
);

SELECT first_name, salary
FROM hr.employees
WHERE salary = (
    SELECT AVG(salary)
    FROM hr.employees
);

SELECT *
FROM orders
WHERE order_date = (
    SELECT MIN(order_date)
    FROM orders
);

SELECT first_name, salary
FROM hr.employees
WHERE salary > (
    SELECT salary
    FROM hr.employees
    WHERE employee_id = 101
);

SELECT name, gpa
FROM students
WHERE gpa = (
    SELECT gpa
    FROM students
    WHERE name = 'John Doe'
);

SELECT *
FROM books
WHERE price = (
    SELECT MAX(price)
    FROM books
    WHERE category_id = (
        SELECT category_id
        FROM categories
        WHERE category_name = 'Science'
    )
);
