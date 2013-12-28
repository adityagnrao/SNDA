
  CREATE TABLE "ADDRESS" 
   (	"AID" NUMBER, 
	"STREET_NO" NUMBER, 
	"STREET_ADDRESS" VARCHAR2(50 BYTE), 
	"CITY" VARCHAR2(30 BYTE), 
	"STATE" VARCHAR2(20 BYTE), 
	"COUNTRY" VARCHAR2(20 BYTE), 
	"ZIP" NUMBER(10,0), 
	"COORDINATE" "MDSYS"."SDO_GEOMETRY" , 
	 PRIMARY KEY ("AID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
   insert into user_sdo_geom_metadata values('ADDRESS','COORDINATE',SDO_DIM_ARRAY(SDO_DIM_ELEMENT('x',0,1000,1),SDO_DIM_ELEMENT('Y',0,1000,1)),8307);
 
  CREATE INDEX "INDEX_ADDRESS" ON "ADDRESS" ("COORDINATE") 
   INDEXTYPE IS "MDSYS"."SPATIAL_INDEX"  PARAMETERS ('layer_gtype=MULTIPOINT ');
   
  
Insert into ADDRESS (AID,STREET_NO,STREET_ADDRESS,CITY,STATE,COUNTRY,ZIP,COORDINATE) values (1,655,'W Jefferson','Los Angeles','CA','Uinted States',90007,MDSYS.SDO_GEOMETRY(2001,8307,MDSYS.SDO_POINT_TYPE(460,434,null),null,null));
Insert into ADDRESS (AID,STREET_NO,STREET_ADDRESS,CITY,STATE,COUNTRY,ZIP,COORDINATE) values (2,8446,'Melrose Pl','Los Angeles','CA','Uinted States',90069,MDSYS.SDO_GEOMETRY(2001,8307,MDSYS.SDO_POINT_TYPE(165,195,null),null,null));
Insert into ADDRESS (AID,STREET_NO,STREET_ADDRESS,CITY,STATE,COUNTRY,ZIP,COORDINATE) values (3,1300,'E Main St','Alhambra','CA','Uinted States',91801,MDSYS.SDO_GEOMETRY(2001,8307,MDSYS.SDO_POINT_TYPE(770,165,null),null,null));
Insert into ADDRESS (AID,STREET_NO,STREET_ADDRESS,CITY,STATE,COUNTRY,ZIP,COORDINATE) values (4,3607,'Trousdale Pkwy','Los Angeles','CA','Uinted States',90089,MDSYS.SDO_GEOMETRY(2001,8307,MDSYS.SDO_POINT_TYPE(450,445,null),null,null));
Insert into ADDRESS (AID,STREET_NO,STREET_ADDRESS,CITY,STATE,COUNTRY,ZIP,COORDINATE) values (5,5757,'Wilshire Blvd','Los Angeles','CA','Uinted States',90036,MDSYS.SDO_GEOMETRY(2001,8307,MDSYS.SDO_POINT_TYPE(310,277,null),null,null));
Insert into ADDRESS (AID,STREET_NO,STREET_ADDRESS,CITY,STATE,COUNTRY,ZIP,COORDINATE) values (6,1133,' N La Brea Ave','West Hollywood','CA','Uinted States',90038,MDSYS.SDO_GEOMETRY(2001,8307,MDSYS.SDO_POINT_TYPE(333,157,null),null,null));
Insert into ADDRESS (AID,STREET_NO,STREET_ADDRESS,CITY,STATE,COUNTRY,ZIP,COORDINATE) values (7,3335,'S Figueroa St.','Los Angeles','CA','Uinted States',90007,MDSYS.SDO_GEOMETRY(2001,8307,MDSYS.SDO_POINT_TYPE(470,430,null),null,null));
Insert into ADDRESS (AID,STREET_NO,STREET_ADDRESS,CITY,STATE,COUNTRY,ZIP,COORDINATE) values (8,2400,'Broadway ','Santa Monica','CA','Uinted States',90404,MDSYS.SDO_GEOMETRY(2001,8307,MDSYS.SDO_POINT_TYPE(45,407,null),null,null));
Insert into ADDRESS (AID,STREET_NO,STREET_ADDRESS,CITY,STATE,COUNTRY,ZIP,COORDINATE) values (9,2,'Griffith Park','Los Angeles','CA','Uinted States',90027,MDSYS.SDO_GEOMETRY(2001,8307,MDSYS.SDO_POINT_TYPE(530,345,null),null,null));
Insert into ADDRESS (AID,STREET_NO,STREET_ADDRESS,CITY,STATE,COUNTRY,ZIP,COORDINATE) values (10,405,'Hilgard Avenue','Los Angeles','CA','Uinted States',90095,MDSYS.SDO_GEOMETRY(2001,8307,MDSYS.SDO_POINT_TYPE(128,246,null),null,null));
Insert into ADDRESS (AID,STREET_NO,STREET_ADDRESS,CITY,STATE,COUNTRY,ZIP,COORDINATE) values (11,1200,'1200 12th Avenue, Los Angeles, CA','Los Angeles ','CA ','Uinted States',90019,MDSYS.SDO_GEOMETRY(2001,8307,MDSYS.SDO_POINT_TYPE(372,334,null),null,null));
Insert into ADDRESS (AID,STREET_NO,STREET_ADDRESS,CITY,STATE,COUNTRY,ZIP,COORDINATE) values (12,3300,'Wilshire Blvd ','Los Angeles ','CA  ','Uinted States',90010,MDSYS.SDO_GEOMETRY(2001,8307,MDSYS.SDO_POINT_TYPE(429,280,null),null,null));
 
   
 
  CREATE TABLE "MEMBERS" 
   (	"EMAIL" VARCHAR2(30 BYTE), 
	"FNAME" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	"PASSWRD" NUMBER NOT NULL ENABLE, 
	"LNAME" VARCHAR2(10 BYTE), 
	"BIRTHDATE" DATE NOT NULL ENABLE, 
	"AID" NUMBER(*,0), 
	 PRIMARY KEY ("EMAIL")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 FOREIGN KEY ("AID")
	  REFERENCES "ADDRESS" ("AID") ON DELETE SET NULL ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
 

Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('angelina@csci585.edu','Angelina',123456,'Jolie',to_timestamp('04-JUN-75','DD-MON-RR HH.MI.SSXFF AM'),1);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('brad@csci585.edu','Brad',123456,'Pitt',to_timestamp('18-DEC-63','DD-MON-RR HH.MI.SSXFF AM'),1);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('al@csci585.edu','Alfredo',123456,'Pacino',to_timestamp('25-APR-70','DD-MON-RR HH.MI.SSXFF AM'),3);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('steve@csci585.edu','Steve',123456,'Jobs',to_timestamp('24-FEB-55','DD-MON-RR HH.MI.SSXFF AM'),2);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('bill@csci585.edu','Bill',123456,'Gates',to_timestamp('28-OCT-55','DD-MON-RR HH.MI.SSXFF AM'),2);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('miley@csci585.edu','Miley',123456,'Cyrus',to_timestamp('23-NOV-92','DD-MON-RR HH.MI.SSXFF AM'),6);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('hope@csci585.edu','Hope',123456,'Solo',to_timestamp('20-JUL-81','DD-MON-RR HH.MI.SSXFF AM'),2);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('andre@csci585.edu','Andre',123456,'Agassi',to_timestamp('29-APR-70','DD-MON-RR HH.MI.SSXFF AM'),8);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('nelle@csci585.edu','Nelle',123456,'Lee',to_timestamp('12-SEP-55','DD-MON-RR HH.MI.SSXFF AM'),2);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('jen@csci585.edu','Jennifer',123456,'Aniston',to_timestamp('11-FEB-69','DD-MON-RR HH.MI.SSXFF AM'),5);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('pit@csci585.edu','Pit',123456,'Sampras',to_timestamp('12-AUG-71','DD-MON-RR HH.MI.SSXFF AM'),5);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('josh@csci585.edu','Josh',123456,'Radnor',to_timestamp('29-JUL-74','DD-MON-RR HH.MI.SSXFF AM'),5);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('tom@csci585.edu','Tom',123456,'Cruise',to_timestamp('03-JUL-62','DD-MON-RR HH.MI.SSXFF AM'),4);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('serina@usc.edu','Serena',123456,'Williams',to_timestamp('26-SEP-81','DD-MON-RR HH.MI.SSXFF AM'),4);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('venus@csci585.edu','Venus',123456,'Williams',to_timestamp('17-JUN-89','DD-MON-RR HH.MI.SSXFF AM'),3);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('fan@csci585.edu','Fan',123456,'Bingbing',to_timestamp('16-SEP-81','DD-MON-RR HH.MI.SSXFF AM'),7);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('jay@csci585.edu','Jay',123456,'Chou',to_timestamp('18-JAN-79','DD-MON-RR HH.MI.SSXFF AM'),7);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('jakie@csci585.edu','Jackie',123456,'Chan',to_timestamp('07-APR-54','DD-MON-RR HH.MI.SSXFF AM'),6);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('andy@csci585.edu','Andy',123456,'Lau',to_timestamp('27-SEP-61','DD-MON-RR HH.MI.SSXFF AM'),10);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('zzhang@csci585.edu','Zhang',123456,'Ziyi',to_timestamp('09-FEB-79','DD-MON-RR HH.MI.SSXFF AM'),8);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('haung@usc.edu','Haung',123456,'Xiaoming',to_timestamp('13-NOV-77','DD-MON-RR HH.MI.SSXFF AM'),10);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('son@csci585.edu','Yeon-Jae',123456,'Son',to_timestamp('28-MAY-94','DD-MON-RR HH.MI.SSXFF AM'),9);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('kim@csci585.edu','Soo-Hyun',123456,'Kim',to_timestamp('16-FEB-88','DD-MON-RR HH.MI.SSXFF AM'),9);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('urm@csci585.edu','Urmila ',123456,'Matondkar',to_timestamp('04-FEB-74','DD-MON-RR HH.MI.SSXFF AM'),9);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('kamal@csci585.edu','Kamal',123456,'Hassan',to_timestamp('07-NOV-54','DD-MON-RR HH.MI.SSXFF AM'),11);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('mani@csci585.edu','Manisha ',123456,'Koirala',to_timestamp('16-AUG-70','DD-MON-RR HH.MI.SSXFF AM'),11);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('niki@csci585.edu','Niki',123456,'Karimi',to_timestamp('10-NOV-71','DD-MON-RR HH.MI.SSXFF AM'),3);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('bbahram@csci585.edu','Bahram',123456,'Radan',to_timestamp('28-APR-79','DD-MON-RR HH.MI.SSXFF AM'),11);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('had@csci585.edu','Hadis',123456,'Fouladvand',to_timestamp('01-JAN-79','DD-MON-RR HH.MI.SSXFF AM'),12);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('tina@csci585.edu','Tina',123456,'Verma',to_timestamp('22-OCT-92','DD-MON-RR HH.MI.SSXFF AM'),6);
Insert into MEMBERS (EMAIL,FNAME,PASSWRD,LNAME,BIRTHDATE,AID) values ('deena@csci585.edu','Deena',123456,'Gandhi',to_timestamp('04-FEB-89','DD-MON-RR HH.MI.SSXFF AM'),12);



  CREATE TABLE "FRIENDSHIP" 
   (	"USER1" VARCHAR2(50 BYTE), 
	"USER2" VARCHAR2(50 BYTE), 
	"UTYPE" VARCHAR2(20 BYTE) NOT NULL ENABLE, 
	 CHECK (utype='Family' or utype='Regular Friend' or utype='Close Friend') ENABLE, 
	 PRIMARY KEY ("USER1", "USER2", "UTYPE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 FOREIGN KEY ("USER1")
	  REFERENCES "MEMBERS" ("EMAIL") ON DELETE CASCADE ENABLE, 
	 FOREIGN KEY ("USER2")
	  REFERENCES "MEMBERS" ("EMAIL") ON DELETE CASCADE ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
 


Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('al@csci585.edu','andre@csci585.edu','Close Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('andre@csci585.edu','fan@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('angelina@csci585.edu','al@csci585.edu','Close Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('angelina@csci585.edu','brad@csci585.edu','Family');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('angelina@csci585.edu','nelle@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('angelina@csci585.edu','niki@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('angelina@csci585.edu','zzhang@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('bbahram@csci585.edu','angelina@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('bbahram@csci585.edu','tina@csci585.edu','Close Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('brad@csci585.edu','haung@usc.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('brad@csci585.edu','hope@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('brad@csci585.edu','nelle@csci585.edu','Close Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('deena@csci585.edu','mani@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('jay@csci585.edu','andy@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('jen@csci585.edu','jakie@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('josh@csci585.edu','jakie@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('josh@csci585.edu','kamal@csci585.edu','Close Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('josh@csci585.edu','nelle@csci585.edu','Close Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('josh@csci585.edu','niki@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('josh@csci585.edu','son@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('miley@csci585.edu','pit@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('nelle@csci585.edu','had@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('nelle@csci585.edu','jen@csci585.edu','Close Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('niki@csci585.edu','bbahram@csci585.edu','Close Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('niki@csci585.edu','had@csci585.edu','Close Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('pit@csci585.edu','venus@csci585.edu','Close Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('serina@usc.edu','tom@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('serina@usc.edu','venus@csci585.edu','Family');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('son@csci585.edu','kim@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('son@csci585.edu','tom@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('steve@csci585.edu','bill@csci585.edu','Close Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('steve@csci585.edu','tina@csci585.edu','Regular Friend');
Insert into FRIENDSHIP (USER1,USER2,UTYPE) values ('urm@csci585.edu','kim@csci585.edu','Close Friend');


  CREATE TABLE "FRIEND_REQUEST" 
   (	"USER1" VARCHAR2(30 BYTE), 
	"USER2" VARCHAR2(30 BYTE), 
	"STATUS" VARCHAR2(20 BYTE), 
	"RTYPE" VARCHAR2(40 BYTE), 
	 CHECK (status='Pending' or status='Friends') ENABLE, 
	 PRIMARY KEY ("USER1", "USER2")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 FOREIGN KEY ("USER1")
	  REFERENCES "MEMBERS" ("EMAIL") ON DELETE CASCADE ENABLE, 
	 FOREIGN KEY ("USER2")
	  REFERENCES "MEMBERS" ("EMAIL") ON DELETE CASCADE ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
 


  CREATE TABLE "POST" 
   (	"POST_ID" NUMBER(*,0), 
	"NOTE" VARCHAR2(1000 BYTE), 
	"SENDER" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	"PRIVACY" NUMBER(*,0) DEFAULT 0, 
	"DATETIME" DATE, 
	 CHECK (privacy=0 or privacy=1 or privacy=2) ENABLE, 
	 PRIMARY KEY ("POST_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 FOREIGN KEY ("SENDER")
	  REFERENCES "MEMBERS" ("EMAIL") ON DELETE CASCADE ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
 

Insert into POST (POST_ID,NOTE,SENDER,PRIVACY,DATETIME) values (1,'"What''s something that adults do that they shouldn''t do?" 
"Punish kids. And war."','angelina@csci585.edu',2,to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST (POST_ID,NOTE,SENDER,PRIVACY,DATETIME) values (2,'"I''m from the Ivory Coast." 
"Why''d you come to America?" 
He formed his hands into two imaginary guns. "Too much boom boom," he said. "So I run."','angelina@csci585.edu',1,to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST (POST_ID,NOTE,SENDER,PRIVACY,DATETIME) values (3,'"What was the happiest moment of your life?" 
"Any time I wake up and nothing hurts."','brad@csci585.edu',2,to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST (POST_ID,NOTE,SENDER,PRIVACY,DATETIME) values (4,'"Everyone loves me. I go everywhere, and I don''t fight with nobody. If somebody''s yelling at me, I just keep walking. I''ve only been in one fight. I used to be a taxi driver. ','nelle@csci585.edu',1,to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST (POST_ID,NOTE,SENDER,PRIVACY,DATETIME) values (5,'"I had this idea to make a portrait, and instead of filling it in with physical features, I filled it in with the verbs that each body part can do."','niki@csci585.edu',2,to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST (POST_ID,NOTE,SENDER,PRIVACY,DATETIME) values (6,'"My dad is big and strong and lifts the heavy weights at the gym. He also is a fireman and he once saved eleven people."','bbahram@csci585.edu',1,to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST (POST_ID,NOTE,SENDER,PRIVACY,DATETIME) values (7,'"If you could give one piece of advice to a large group of people, what would it be?" 
"Be optimistic."','had@csci585.edu',2,to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST (POST_ID,NOTE,SENDER,PRIVACY,DATETIME) values (8,'Today in microfashion...','kim@csci585.edu',1,to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST (POST_ID,NOTE,SENDER,PRIVACY,DATETIME) values (9,'"If you could give one piece of advice to a large group of people, what would it be?" 
"Enjoy it while it lasts."','zzhang@csci585.edu',0,to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST (POST_ID,NOTE,SENDER,PRIVACY,DATETIME) values (10,'"I''m breaking out of my shell."','andy@csci585.edu',1,to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));


  CREATE TABLE "POST_COMMENT" 
   (	"PID" NUMBER(*,0), 
	"TEXT" VARCHAR2(50 BYTE), 
	"MID" VARCHAR2(30 BYTE) NOT NULL ENABLE, 
	"DATETIME" DATE, 
	 PRIMARY KEY ("PID", "MID", "DATETIME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 FOREIGN KEY ("MID")
	  REFERENCES "MEMBERS" ("EMAIL") ON DELETE CASCADE ENABLE, 
	 FOREIGN KEY ("PID")
	  REFERENCES "POST" ("POST_ID") ON DELETE CASCADE ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
 

Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (1,'GREAT!','andre@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (3,'GREAT!','andre@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (5,'GREAT!','andre@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (7,'GREAT!','andre@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (1,'GREAT!','brad@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (3,'AWESOME!','brad@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (5,'AWESOME!','brad@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (7,'AWESOME!','brad@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (1,'AWESOME!','steve@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (3,'AWESOME!','steve@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (5,'AMAZING!','steve@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (7,'AMAZING!','steve@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (1,'AMAZING!','niki@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (3,'AMAZING!','niki@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (5,'AMAZING!','niki@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (7,'AMAZING!','niki@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (1,'REALLY?','haung@usc.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (3,'REALLY?','haung@usc.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (5,'REALLY?','haung@usc.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (7,'REALLY?','haung@usc.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (1,'REALLY?','kamal@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (3,'REALLY?','kamal@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (5,'COOL!','kamal@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (7,'COOL!','kamal@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (2,'COOL!','al@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (4,'COOL!','had@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (6,'COOL!','angelina@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (8,'COOL!','son@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (10,'COOL!','jay@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));
Insert into POST_COMMENT (PID,TEXT,MID,DATETIME) values (2,'COOL!','nelle@csci585.edu',to_timestamp('14-SEP-13','DD-MON-RR HH.MI.SSXFF AM'));


  CREATE TABLE "EVENT" 
   (	"TITLE" VARCHAR2(30 BYTE), 
	"DESCRIPTION" VARCHAR2(1000 BYTE), 
	"ADDRESS_ID" NUMBER(*,0), 
	"STARTING_TIME" TIMESTAMP (6), 
	"EVENT_DURATION" INTERVAL DAY (2) TO SECOND (4), 
	 PRIMARY KEY ("TITLE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 FOREIGN KEY ("ADDRESS_ID")
	  REFERENCES "ADDRESS" ("AID") ON DELETE SET NULL ENABLE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
 
Insert into EVENT (TITLE,DESCRIPTION,ADDRESS_ID,STARTING_TIME,EVENT_DURATION) values ('Tailgate 13','Football & Tailgate Tickets USC Trojans vs. UTAH Utes Saturday, October 26th. Join us for a tailgate three hours prior to kickoff',5,to_timestamp('26-OCT-13 12.00.00.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'0 2:0:0.0');
Insert into EVENT (TITLE,DESCRIPTION,ADDRESS_ID,STARTING_TIME,EVENT_DURATION) values ('Superbowl 13','The Super Bowl is the annual championship game of the National Football League (NFL), the highest level of professional American football in the United States, culminating a season that begins in the late summer of the previous calendar year.',4,to_timestamp('15-DEC-13 12.00.00.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'0 4:0:0.0');
Insert into EVENT (TITLE,DESCRIPTION,ADDRESS_ID,STARTING_TIME,EVENT_DURATION) values ('NBAFinals 13','The NBA Finals is the championship series of the National Basketball Association. The series was named the NBA World Championship Series until 1986.',3,to_timestamp('15-JAN-13 12.00.00.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'0 3:0:0.0');
Insert into EVENT (TITLE,DESCRIPTION,ADDRESS_ID,STARTING_TIME,EVENT_DURATION) values ('Oscars 13','The Academy Awards, now officially known as The Oscars,[1] are a set of awards given annually for excellence of cinematic achievements. The Oscar statuette is officially named the Academy Award of Merit and is one of nine types of Academy Awards.',3,to_timestamp('11-NOV-13 12.00.00.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'0 5:0:0.0');
Insert into EVENT (TITLE,DESCRIPTION,ADDRESS_ID,STARTING_TIME,EVENT_DURATION) values ('US OPEN 13','The United States Open Tennis Championships is a hardcourt tennis tournament which is the modern iteration of one of the oldest tennis championships in the world, the U.S. National Championship, for which men''s singles was first contested in 1881.',2,to_timestamp('10-SEP-13 12.00.00.000000000 AM','DD-MON-RR HH.MI.SS.FF AM'),'14 0:0:0.0');


  CREATE OR REPLACE FUNCTION "GET_NEAREST_NEIGHBOR" 
( userid IN VARCHAR2
) RETURN sys_refcursor AS rc sys_refcursor;
BEGIN
OPEN rc for


  CREATE OR REPLACE FUNCTION "TEST2"."GET_NEAREST_NEIGHBOR" 
( userid IN VARCHAR2
) RETURN sys_refcursor AS rc sys_refcursor;
BEGIN
OPEN rc for

with temp as (select a.aid as aid,a.coordinate as coordinate from address a,members m where m.email=userid and m.aid= a.aid)
select m1.email, m1.fname, m1.lname, a1.street_no, a1.street_address, a1.city, a1.state, a1.country from members m1, address a1,friendship f
where m1.aid= a1.aid 
and ((m1.email=f.user1 and f.user2= userid)or (m1.email=f.user2 and f.user1= userid))
and a1.aid  IN(SELECT  b.aid FROM address b  WHERE SDO_NN(b.coordinate,
  (select temp.coordinate from temp), 'sdo_num_res=2') = 'TRUE');
--  and b.aid!= (select temp.aid from temp));

  RETURN rc;
END GET_NEAREST_NEIGHBOR;
/
 



  CREATE UNIQUE INDEX "INDMEM" ON "MEMBERS" ("EMAIL", "FNAME", "LNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  GLOBAL PARTITION BY HASH ("EMAIL") 
 (PARTITION "PARTITION1" 
   TABLESPACE "USERS" , 
 PARTITION "PARTITION2" 
   TABLESPACE "USERS" , 
 PARTITION "PARTITION3" 
   TABLESPACE "USERS" , 
 PARTITION "PARTITION4" 
   TABLESPACE "USERS" ) ;
 

commit;
