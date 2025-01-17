-- Write your PostgreSQL query statement below
SELECT DISTINCT t1.name from salesperson t1  LEFT JOIN orders t2 ON t1.sales_id = t2.sales_id WHERE t1.sales_id NOT IN (SELECT DISTINCT sales_id from orders WHERE com_id = (SELECT com_id from company where name = 'RED'));
