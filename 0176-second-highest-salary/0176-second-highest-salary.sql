-- # Write your MySQL query statement below

-- Method 1
-- select MAX(salary) as SecondHighestSalary from employee
-- where salary < (select MAX(salary) from employee);


-- Method 2
SELECT (
    SELECT DISTINCT salary
    FROM Employee
    ORDER BY salary DESC
    LIMIT 1 OFFSET 1
) AS SecondHighestSalary;