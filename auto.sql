create table engine (id serial primary key, name varchar(50));
create table transmission (id serial primary key, name varchar(50));
create table body (id serial primary key, name varchar(50));
create table auto (id serial primary key,
                   name varchar(50),
                   engine_id int references engine,
                   transmission_id int references transmission,
                   body_id int references body);

insert into body (name) values ('body1'), ('bodi2'), ('body3');
insert into transmission (name) values ('trans1'), ('trans2'), ('trans3');
insert into engine (name) values ('engine1'), ('engine2'), ('engine3');
insert into auto (name, engine_id, transmission_id, body_id) values ('auto1',1,1,1), ('auto2',3,2,1);

select a.name, e.name, b.name, t.name
            from auto a
            join body b on a.body_id = b.id
            join engine e on e.id = a.engine_id
            join transmission t on a.transmission_id = t.id;

select a.name, e.name, b.name, t.name
            from auto a
            full join body b on a.body_id = b.id
            full join engine e on e.id = a.engine_id
            full join transmission t on a.transmission_id = t.id
            where a.name is null;