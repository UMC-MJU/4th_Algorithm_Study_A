# sql week4
```
select MCDP_CD "진료과코드",count(MCDP_CD) "5월예약건수"
 from appointment 
where apnt_ymd between '2022-05-01' and '2022-05-31'
group by MCDP_CD
order by count(MCDP_CD) ,MCDP_CD
```

```
SELECT DATETIME "시간" 
from ANIMAL_INS
order by datetime desc
limit 1
```