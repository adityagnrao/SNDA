select p.photo_code,p.place_title
from took_at p
where p.place_title in 
(select title from (
select distinct title,count(*)from place, checkedin
where place.title= checkedin.place_title
group by place.title
order by count(*) desc)
where rownum<=5);