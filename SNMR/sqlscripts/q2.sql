select birthmonth,avg(age),min(age), max(age),count(*) as NUM_USERS
from Members 
group by birthmonth
order by avg(age) Desc;