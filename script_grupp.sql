SELECT avg(price) FROM devices_people
                  join devices d on d.id = devices_people.device_id;
SELECT p. name, avg(price) FROM devices_people
                join people p on devices_people.people_id = p.id
                join devices d on d.id = devices_people.device_id
                group by p.name;
SELECT p. name, avg(price) FROM devices_people
                join people p on devices_people.people_id = p.id
                join devices d on d.id = devices_people.device_id where price > 5000
                group by p.name;