select EMAIL,FNAME,LNAME, nvl(PCOUNT,0) as PHOTO_COUNT from(
(select email,fname,lname FROM
members) 
Natural left outer join
(select email,fname,lname,sum(nvl(t1.scount,0)+nvl(t2.pcount,0)+nvl(t3.fcount,0))as Pcount from(
(select m.email,m.fname,m.lname,count(*) as scount
from members m,post p, photo ph
where m.email= p.sender and p.post_id= ph.postid
group by m.email,m.fname,m.lname)t1
Natural left outer join
(select m.email,m.fname,m.lname,count(*) as pcount
from members m,post p, photo ph
where m.email!= p.sender and p.post_id=ph.postid and( p.privacy=2)
group by m.email,m.fname,m.lname)t2
Natural left outer join
(select m.email,m.fname,m.lname,count(*) as fcount
from members m,post p, photo ph,friendship f
where m.email!= p.sender and f.user1= p.sender and f.user2= m.email and p.post_id= ph.postid and p.privacy=1
group by m.email,m.fname,m.lname)t3)
group by email,fname,lname)
)
order by PHOTO_COUNT desc,fname asc,lname asc;