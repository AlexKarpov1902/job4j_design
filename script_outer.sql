select * from departments left join emploees e on departments.id = e.department_id;
select * from departments right join emploees e on departments.id = e.department_id;
select * from departments full outer join emploees e on departments.id = e.department_id;
select * from departments cross join emploees;
select * from emploees left join departments d on emploees.department_id = d.id where department_id is null;


create table teens (id serial primary key , name varchar(50), gender char);
insert into teens (name, gender) VALUES ('man1','M');
insert into teens (name, gender) VALUES ('man2','M');
insert into teens (name, gender) VALUES ('man3','M');
insert into teens (name, gender) VALUES ('man4','M');
insert into teens (name, gender) VALUES ('fem1','F');
insert into teens (name, gender) VALUES ('fem2','F');
insert into teens (name, gender) VALUES ('fem3','F');

select * from teens m cross join (select * from teens where gender='M') f where m.gender<>f.gender;