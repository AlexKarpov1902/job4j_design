DROP TABLE IF EXISTS persons;
DROP TABLE IF EXISTS positions;
CREATE TABLE positions (id serial primary key , name varchar(50));
CREATE TABLE persons (id serial primary key , name varchar(50),
                      salary numeric (10, 0),
                      date_in date,
                      position_id int references positions);
INSERT INTO positions (name) VALUES ('Программист');
INSERT INTO positions (name) VALUES ('Дизайнер');
INSERT INTO positions (name) VALUES ('Тестировщик');
INSERT INTO positions (name) VALUES ('Уборщица');
INSERT INTO persons (name, salary, date_in, position_id) VALUES ('Petr', 10000, '01.12.2020', 2);
INSERT INTO persons (name, salary, date_in, position_id) VALUES ('Ivan', 15000, '01.12.2019', 1);
INSERT INTO persons (name, salary, date_in, position_id) VALUES ('Max', 12000, '01.12.2018', 1);
INSERT INTO persons (name, salary, date_in, position_id) VALUES ('Den', 15000, '01.11.2020', 3);
SELECT p.name, p.date_in, p.salary, s.name
       FROM persons as p
           JOIN positions as s ON p.position_id = s.id;
SELECT p.name, p.date_in, p.salary, s.name
       FROM persons as p
           RIGHT JOIN positions as s ON p.position_id = s.id;
SELECT p.name, p.date_in, p.salary, s.name
       FROM persons as p
           JOIN positions as s ON p.position_id = s.id WHERE p.salary > 13000;