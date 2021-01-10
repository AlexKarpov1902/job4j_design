INSERT INTO roles (role_name) values ('USER');
INSERT INTO roles (role_name) values ('ADMINISTRATOR');
INSERT INTO roles (role_name) values ('VISITOR');
INSERT INTO users (name, role_id) values ('Ivan',1);
INSERT INTO users (name, role_id) values ('Petr',2);
INSERT INTO users (name, role_id) values ('Max',3);
INSERT INTO rules (rule) values ('CREATE TABLES');
INSERT INTO rules (rule) values ('MODIFY TABLES');
INSERT INTO rules (rule) values ('INSERT');
INSERT INTO rule_role (role_id, rule_id) values (1,1);
INSERT INTO rule_role (role_id, rule_id) values (1,2);
INSERT INTO rule_role (role_id, rule_id) values (1,3);
INSERT INTO rule_role (role_id, rule_id) values (2,2);
INSERT INTO rule_role (role_id, rule_id) values (3,3);
INSERT INTO states (state) values ('ПРИНЯТО');
INSERT INTO states (state) values ('НА РАССМОТРЕНИИ');
INSERT INTO states (state) values ('ЗАКРЫТА');
INSERT INTO categories (category) values ('ПЛАНОВАЯ');
INSERT INTO categories (category) values ('СРОЧНАЯ');
INSERT INTO categories (category) values ('СУПЕРСРОЧНАЯ');
INSERT INTO items (items_num, user_id, category_id, state_id) VALUES (1,1,1,1);
INSERT INTO items (items_num, user_id, category_id, state_id) VALUES (2,2,1,1);
INSERT INTO items (items_num, user_id, category_id, state_id) VALUES (3,3,1,1);
INSERT INTO comments (item_id, note) VALUES (1, 'комментарий 1');
INSERT INTO comments (item_id, note) VALUES (2, 'комментарий 2');
INSERT INTO comments (item_id, note) VALUES (3, 'комментарий 3');
INSERT INTO attachs (item_id, files) VALUES (1, 'file 1');
INSERT INTO attachs (item_id, files) VALUES (1, 'file 2');
INSERT INTO attachs (item_id, files) VALUES (1, 'file 3');
INSERT INTO attachs (item_id, files) VALUES (2, 'file 4');
INSERT INTO attachs (item_id, files) VALUES (2, 'file 5');
INSERT INTO attachs (item_id, files) VALUES (3, 'file 6');