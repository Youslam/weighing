-- create table
create table user
(
  id         	bigint not null,
  login         varchar(36) not null,
  email         varchar(50) not null,
  name         	varchar(36) not null,
  password 		varchar(128) not null,
  enabled       bit not null 
) ;
--  
alter table user
  add constraint user_pk primary key (id);
 
alter table user
  add constraint user_uk unique (login);
 
 
-- create table
create table role
(
  id   bigint not null,
  name varchar(30) not null
);
--  
alter table role
  add constraint role_pk primary key (id);
 
alter table role
  add constraint role_uk unique (name);
 
 
-- create table
create table user_role
(
  id      bigint not null,
  user_id bigint not null,
  role_id bigint not null
);
--  
alter table user_role
  add constraint user_role_pk primary key (id);
 
alter table user_role
  add constraint user_role_uk unique (user_id, role_id);
 
alter table user_role
  add constraint user_role_fk1 foreign key (user_id)
  references user (id);
 
alter table user_role
  add constraint user_role_fk2 foreign key (role_id)
  references role (id);
 
 
-- used by spring remember me api.  
create table persistent_logins (
 
    username varchar(64) not null,
    series varchar(64) not null,
    token varchar(64) not null,
    last_used timestamp not null,
    primary key (series)
     
);
 
--------------------------------------