-- Create table
create table `user`
(
  ID         	BIGINT not null,
  LOGIN         VARCHAR(36) not null,
  EMAIL         VARCHAR(50) not null,
  NAME         	VARCHAR(36) not null,
  PASSWORD 		VARCHAR(128) not null,
  ENABLED       BIT not null 
) ;
--  
alter table USER
  add constraint USER_PK primary key (ID);
 
alter table USER
  add constraint USER_UK unique (LOGIN);
 
 
-- Create table
create table ROLE
(
  ID   BIGINT not null,
  NAME VARCHAR(30) not null
);
--  
alter table ROLE
  add constraint ROLE_PK primary key (ID);
 
alter table ROLE
  add constraint ROLE_UK unique (NAME);
 
 
-- Create table
create table USER_ROLE
(
  ID      BIGINT not null,
  USER_ID BIGINT not null,
  ROLE_ID BIGINT not null
);
--  
alter table USER_ROLE
  add constraint USER_ROLE_PK primary key (ID);
 
alter table USER_ROLE
  add constraint USER_ROLE_UK unique (USER_ID, ROLE_ID);
 
alter table USER_ROLE
  add constraint USER_ROLE_FK1 foreign key (USER_ID)
  references USER (ID);
 
alter table USER_ROLE
  add constraint USER_ROLE_FK2 foreign key (ROLE_ID)
  references ROLE (ID);
 
 
-- Used by Spring Remember Me API.  
CREATE TABLE Persistent_Logins (
 
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    PRIMARY KEY (series)
     
);
 
--------------------------------------