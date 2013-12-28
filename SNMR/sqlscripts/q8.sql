SELECT m.email
FROM members m
WHERE NOT EXISTS (SELECT p.title
FROM Place p 
WHERE NOT EXISTS (SELECT d.place_title
FROM Checkedin d
WHERE d.place_title=p.title
AND d.member_id=m.email));

