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
insert into course (id, name) values (1005, 'Udemy - Spring Cloud');
insert into course (id, name) values (1006, 'Udemy - Docker');
insert into course (id, name) values (1007, 'Udemy - Elastic Search');

insert into student (id, name) values (200001, 'Ranga');
insert into student (id, name) values (200002, 'Adam');
insert into student (id, name) values (200003, 'Jane');

insert into passport (id, number) values (300001, 'E123456');
insert into passport (id, number) values (300002, 'N929812');
insert into passport (id, number) values (300003, 'L219213');

insert into review (id, rating, description) values (400001, '5', 'Great Course');
insert into review (id, rating, description) values (400002, '4', 'Awesome Course');
insert into review (id, rating, description) values (400003, '5', 'Amazing Course');