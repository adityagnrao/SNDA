select fname,lname
from members 
where email IN (
select f.user2
from members m,friendship f
where (m.email='angelina@csci585.edu')  and m.email= f.user1
Intersect
select f.user2
from members m,friendship f
where (m.email='niki@csci585.edu')  and m.email= f.user1);