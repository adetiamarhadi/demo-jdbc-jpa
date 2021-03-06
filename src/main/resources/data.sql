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

insert into course (id, name, is_deleted) values (1004, 'Udemy - Hibernate', false);
insert into course (id, name, is_deleted) values (1005, 'Udemy - Spring Cloud', false);
insert into course (id, name, is_deleted) values (1006, 'Udemy - Docker', false);
insert into course (id, name, is_deleted) values (1007, 'Udemy - Elastic Search', false);
insert into course (id, name, is_deleted) values (1008, 'Udemy - Angular with 100 Steps', false);

insert into passport (id, number) values (300001, 'E123456');
insert into passport (id, number) values (300002, 'N929812');
insert into passport (id, number) values (300003, 'L219213');

insert into student (id, name, passport_id) values (200001, 'Ranga', 300001);
insert into student (id, name, passport_id) values (200002, 'Adam', 300002);
insert into student (id, name, passport_id) values (200003, 'Jane', 300003);

insert into review (id, rating, description, course_id) values (400001, 'FIVE', 'Great Course', 1005);
insert into review (id, rating, description, course_id) values (400002, 'FOUR', 'Awesome Course', 1006);
insert into review (id, rating, description, course_id) values (400003, 'FIVE', 'Amazing Course', 1005);

insert into student_course (student_id, course_id) values (200001, 1004);
insert into student_course (student_id, course_id) values (200001, 1007);
insert into student_course (student_id, course_id) values (200003, 1004);