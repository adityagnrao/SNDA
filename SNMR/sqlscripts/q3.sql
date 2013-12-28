select email,fname,lname,coalesce(fcount,0) as FAMILY_COUNT from (
(select email,fname,lname
from members)
Natural left outer join
(select  email,fname,lname,count(*) as fcount
from (SELECT email,fname,lname,utype FROM members, friendship
where  (email=user1 or email=user2))
where utype='Family'
group by email,fname,lname));