# sql week3
# 상품 별 오프라인 매출 구하기
```
select p.product_code "PRODUCT_CODE", sum(o.sales_amount) * p.price "SALES"
from offline_sale o
natural join product p
group by o.product_id 
order by SALES desc, PRODUCT_CODE 
```
 

# 성분으로 구분한 아이스크림 총 주문량 
```
SELECT i.ingredient_type, sum(f.total_order) TOTAL_ORDER
from first_half f
natural join icecream_info i
group by i.ingredient_type
order by total_order
```