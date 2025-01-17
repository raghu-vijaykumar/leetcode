-- Write your PostgreSQL query statement below
SELECT name from customer where referee_id != 2 OR referee_id IS NULL OR id = 2;