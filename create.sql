CREATE TABLE users (id serial primary key,
                    name varchar(100),
                    role_id int references roles(id));
CREATE TABLE roles (id serial primary key,
                    role_name varchar(100));
CREATE TABLE rules (id serial primary key, rule varchar(100) );
CREATE TABLE rule_role (id serial primary key, rule_id int references rules(id),
                        role_id int references roles(id));
CREATE TABLE items (id serial primary key, items_num int, user_id int references users(id));
CREATE TABLE comments (id serial primary key, note text, item_id int references items(id));
CREATE TABLE attachs (id serial primary key, files text, item_id int references items(id));
CREATE TABLE categories (id serial primary key, category varchar(100));
CREATE TABLE states (id serial primary key, state varchar(100));
ALTER TABle items add column category_id int references categories(id);
ALTER TABle items add column state_id int references states(id);
