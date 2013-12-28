select m.email,m.fname,m.lname,count(*) as photocount
from members m,post p,photo ph
where m.email= p.sender and p.post_id=ph.postid
group by m.email,m.fname,m.lname,p.post_id, ph.postid
                  having count(*)>=all(select count(*) from members, post, photo
                                      where members.email=post.sender and post.post_id= photo.postid
                                      group by members.email,post.post_id, photo.postid);