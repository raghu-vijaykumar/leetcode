-- Write your PostgreSQL query statement below
SELECT MAX(SecondHighestSalary) AS SecondHighestSalary FROM(
SELECT CASE WHEN rn = 2 THEN salary ELSE null END as SecondHighestSalary from (
select salary, dense_rank() over (order by salary desc) as rn from employee))