CREATE OR REPLACE TRIGGER "COMPUTE_AGE_MONTH" 
before insert on Members
referencing new as new_member
for each row
BEGIN
--:new_member.birthmonth := month(new_member.birthdate);
:new_member.age := floor(months_between(sysdate,:new_member.birthdate)/12);
--:new_member.age := (year(sysdate)-year(new_member.birthdate));
:new_member.birthmonth :=  to_char(:new_member.birthdate,'MONTH');
END;
/
