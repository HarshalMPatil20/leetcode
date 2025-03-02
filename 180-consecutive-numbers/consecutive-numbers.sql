# Write your MySQL query statement below
select distinct L1.num as ConsecutiveNums
from Logs L1 join Logs L2 on L1.id+1 = L2.id
join Logs L3 on L2.id+1 = L3.id
where L1.num=L2.num and L2.num=L3.num