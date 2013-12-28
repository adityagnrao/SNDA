select m.email,m.fname,m.lname,pl.title,count(*) as photo_count
from members m,place pl
where m.email in (select sender from post WHERE
                   post.post_id in ( select postid from photo ,place p, took_at t
                   where p.title= pl.title and photo.code=t.photo_code and t.place_title=p.title
                   and pl.address_id in ( select aid from address)))
                   group by (m.email,m.fname,m.lname,pl.title)
                   order by photo_count desc,fname,lname;