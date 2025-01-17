SELECT id
FROM   (SELECT id,
               temperature                  AS curr,
               recorddate                   AS curDate,
               Lag(temperature)
                 OVER (
                   partition BY 1
                   ORDER BY recorddate ASC) AS prev,
               Lag(recorddate)
                 OVER (
                   partition BY 1
                   ORDER BY recorddate ASC) prevDate
        FROM   weather)
WHERE  prev IS NOT NULL
       AND curr - prev > 0
       AND prevdate IS NOT NULL
       AND curdate - prevdate = 1; 