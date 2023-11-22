# # sql week5

1. 있었는데요 없었습니다
select a.animal_id, a.name
from ANIMAL_INS a join ANIMAL_OUTS b
on a.ANIMAL_ID = b.ANIMAL_ID
where b.DATETIME< a.DATETIME
order by a.datetime;

2. 없어진 기록 찾기
SELECT b.animal_id, b.name
from animal_ins a right outer join animal_outs b on a.animal_id = b.animal_id 
where a.animal_id IS null
order by b.animal_id;