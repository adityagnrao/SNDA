select m.email,m.fname,m.lname, w.rating
from members m,watched w
where m.email=w.member_id and w.movie_id in(select movie_id from(select distinct movie_id , avg(rating) as AVG_RATING from watched
group by movie_id
having count(*)>=all(select count(*) from watched
                    group by movie_id)))
and w.rating >
(select avg(rating) as AVG_RATING from watched
group by movie_id
having count(*)>=all(select count(*) from watched
                    group by movie_id))
order by fname asc,lname asc;                 
