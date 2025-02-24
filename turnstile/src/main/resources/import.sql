
DROP TABLE IF EXISTS log;

DROP TABLE IF EXISTS employee;
DROP TABLE IF EXISTS role;



CREATE TABLE role ( id SERIAL PRIMARY KEY, level INT NOT NULL, description VARCHAR(100));

CREATE TABLE employee ( id SERIAL PRIMARY KEY, name VARCHAR(50) NOT NULL, surname VARCHAR(50) NOT NULL, email VARCHAR(100) NOT NULL, role_id INT NOT NULL, FOREIGN KEY (role_id) REFERENCES role(id));

CREATE TABLE log( id SERIAL PRIMARY KEY, employee_id INT NOT NULL, date DATE NOT NULL, enter_time TIMESTAMP NOT NULL, exit_time TIMESTAMP NOT NULL, FOREIGN KEY (employee_id) REFERENCES employee(id));

INSERT INTO role (level, description) VALUES (1, 'Admin');
INSERT INTO role (level, description) VALUES (2, 'Manager');
INSERT INTO role (level, description) VALUES (3, 'Senior');
INSERT INTO role (level, description) VALUES (4, 'Mid');
INSERT INTO role (level, description) VALUES (5, 'Junior');
INSERT INTO role (level, description) VALUES (6, 'Stage');


INSERT INTO employee (name, surname, email, role_id) VALUES ('Admin', 'Admin', 'admin@gmail.com', 1);
INSERT INTO employee (name, surname, email, role_id) VALUES ('Foo', 'Bar', 'baz@gmail.com', 2);
INSERT INTO employee (name, surname, email, role_id) VALUES ('Lorem', 'Ipsum', 'abc@gmail.com', 3);
INSERT INTO employee (name, surname, email, role_id) VALUES ('Test', 'Test', 'test@gmail.com', 4);
INSERT INTO employee (name, surname, email, role_id) VALUES ('Martina', '123', 'marty@gmail.com', 5);
INSERT INTO employee (name, surname, email, role_id) VALUES ('Riccardo', 'Leone', 'admin@gmail.com', 6);



