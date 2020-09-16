--create table person (
--id integer not null,
--name varchar(255) not null,
--location varchar(255),
--birth_date timestamp,
--primary key(id)
--);

insert into person (id, name, location, birth_date) values (1001, 'Adet', 'Bekasi', sysdate());
insert into person (id, name, location, birth_date) values (1002, 'Avril', 'Jakarta', sysdate());
insert into person (id, name, location, birth_date) values (1003, 'Tataz', 'Bekasi', sysdate());

insert into course (id, name) values (1004, 'Udemy - Hibernate');