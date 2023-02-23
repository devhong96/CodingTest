-- 코드를 입력하세요
select fruit.FLAVOR
from first_half fruit
join icecream_info info
on fruit.flavor = info.flavor
where total_order>3000 and INGREDIENT_TYPE='fruit_based' 
order by total_order desc;