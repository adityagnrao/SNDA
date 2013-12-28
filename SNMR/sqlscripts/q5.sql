select distinct b.email,d.email,b.country,b.state,b.city
from members b,members d
where b.city  in
(select distinct m.city
from members m, invited i
where m.city not in(
select city 
from event,address
where event.address_id= aid )
and (i.mid= m.email and i.state='Going')
group by  m.city
having count(m.city)=2 ) 
and  d.city in 
(select distinct m.city
from members m, invited i
where m.city not in(
select city 
from event,address
where event.address_id= aid )
and (i.mid= m.email and i.state='Going')
group by  m.city
having count(m.city)=2 ) 
and b.city=d.city and d.email!= b.email(+)
order by b.email asc,d.email asc;