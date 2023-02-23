-- 코드를 입력하세요
select outs.ANIMAL_ID, outs.NAME
from ANIMAL_outs outs
left outer join animal_ins ins
on ins.ANIMAL_ID = outs.ANIMAL_ID
where ins.animal_id is null
order by outs.animal_id;
