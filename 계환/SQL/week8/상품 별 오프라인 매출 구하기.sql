SELECT p.product_code, SUM(p.price * o.sales_amount) AS SALES
FROM PRODUCT AS p
         JOIN OFFLINE_SALE AS o ON p.product_id = o.product_id
GROUP BY p.product_code
ORDER BY SALES DESC, p.product_code ASC;
