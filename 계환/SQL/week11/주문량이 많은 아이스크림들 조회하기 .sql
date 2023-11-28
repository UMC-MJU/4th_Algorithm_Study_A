SELECT f.FLAVOR
FROM FIRST_HALF AS f
         JOIN JULY AS j
              ON f.flavor = j.flavor
GROUP BY FLAVOR
ORDER BY SUM(f.total_order) + SUM(j.total_order) DESC
    LIMIT 3;
