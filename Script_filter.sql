select t.name, p.* from product  p join type  t on p.type_id = t.id where t.name = 'СЫР';
select t.name, p.* from product  p join type  t on p.type_id = t.id where p.name LIKE '%мороженое%';
select t.name, p.* from product  p join type  t on p.type_id = t.id
where p.expired_date between current_date and current_date + interval '1 month';
select  * from product where price = (select max(price) from product);
select t.name, count(p.*) from product p
    join type  t on p.type_id = t.id
    group by t.name;
select t.name, p.* from product  p
    join type  t on p.type_id = t.id
    where t.name = 'СЫР' or t.name ='МОЛОКО';
select t.name, count(p.*) as kol  from product p
    join type  t on p.type_id = t.id
    group by t.name having count(p.*)<10;
select t.name, p.* from product  p join type  t on p.type_id = t.id;
