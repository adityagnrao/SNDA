select EMAIL,FNAME,LNAME,nvl(GOING1,0) as going,nvl(MAYBE1,0)as maybe,nvl(NOT_GOING1,0)as not_going from (
(select m.email,m.fname,m.lname,nvl(count(*),0) as GOING1
from members m,invited i
where m.email =i.mid 
and i.state='Going'
group by (m.email,m.fname,m.lname)
/*order by GOING desc*/)
natural left outer join
(select m.email,m.fname,m.lname,nvl(count(*),0) as MAYBE1
from members m,invited i
where m.email=i.mid
and i.state='Maybe'
group by (m.email,m.fname,m.lname)
/*order by MAYBE desc*/)
natural left outer join
(select m.email,m.fname,m.lname, nvl(count(*),0) as NOT_GOING1
from members m,invited i
where m.email=i.mid
and i.state='Not Going'
group by (m.email,m.fname,m.lname)
/*order by NOT_GOING desc*/)
) order by GOING desc,NOT_GOING desc,MAYBE desc;

