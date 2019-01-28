insert into user (id, login, email, name, password, enabled)
values (2, 'dbuser1', 'user@test.com',  'User Test', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
insert into user (id, login, email, name, password, enabled)
values (1, 'dbadmin1', 'admin@test.com', 'Admin Test', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
---
 
insert into role (id, name)
values (1, 'ROLE_ADMIN');
 
insert into role (id, name)
values (2, 'ROLE_USER');
 
---
 
insert into user_role (user_id, role_id)
values (1, 1);
 
insert into user_role (user_id, role_id)
values (1, 2);
 
insert into user_role (user_id, role_id)
values (2, 2);