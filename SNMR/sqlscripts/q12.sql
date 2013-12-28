select pltemp.post_ID as POSTID, pltemp.pcount, pltemp.lcount,pltemp.sender,fname,lname
from members Inner join
(select * from (
(select t1.post_id,t1.sender,count(*) as pcount from post_comment pc
inner join 
(select post_id,sender, count(*) as rating from post, post_comment, post_like
where post_id=post_comment.pid and post_id=post_like.pid
group by post_id,sender
having count(*)>= all(select count(*) from post p, post_comment pc,post_like pl
where p.post_id= pc.pid and p.post_id= pl.pid
group by p.post_id))t1 
on t1.post_id= pc.pid
group by t1.post_id,t1.sender)ptemp
natural left outer join
(select t1.post_id,t1.sender,count(*) as lcount from post_like pl
inner join 
(select post_id,sender, count(*) as rating from post, post_comment, post_like
where post_id=post_comment.pid and post_id=post_like.pid
group by post_id,sender
having count(*)>= all(select count(*) from post p, post_comment pc,post_like pl
where p.post_id= pc.pid and p.post_id= pl.pid
group by p.post_id))t1 
on t1.post_id= pl.pid
group by t1.post_id,t1.sender)ltemp))pltemp
on pltemp.sender=members.email;
