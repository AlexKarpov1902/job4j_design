
create table prod
(   id       serial PRIMARY KEY,
    name_prod     TEXT,
    price    numeric(10,2) CHECK ( price > 0 ),
    date     DATE,
    time_cur TIMESTAMP default CURRENT_TIMESTAMP,
    shotr_name varchar(30),
    testing boolean);
insert into prod (name_prod, price, date, shotr_name,testing)
VALUES ('Automobile fdsdfg dg dsf sdg dsgf sdg',23.56,'07.01.2021','Auto',true);
select  * from prod;
delete FROM prod where id=1;
