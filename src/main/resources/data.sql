-- noinspection SqlResolveForFile

INSERT INTO User (id, first_name, last_name, username, password, enabled, phone_number, email, color, starting_date,
                  birth_date)
VALUES (1, 'Mario', 'Obradovic', 'mario', '$2a$12$C1JUcM4EcttW8ox0r8GKU.mhjganne2n1RhVMCxTvlba5oCKUEQwa', 1,
        '+381638558708', 'mariyo88vp@gmail.com', 'red', '01.01.2020', '01.09.1988');
INSERT INTO User (id, first_name, last_name, username, password, enabled, phone_number, email, color, starting_date,
                  birth_date)
VALUES (2, 'Stefan', 'Petrovic', 'funSte', '$2a$10$s.eTtPhyBJukkMyB4//Qfu1S0n47t6JeBp9OQglqv9wxcTDQocyUe', 1,
        '+381637766888', 'stefan@gmail.com', 'blue', '01.01.2020', '06.01.1991');
INSERT INTO User (id, first_name, last_name, username, password, enabled, phone_number, email, color, starting_date,
                  birth_date)
VALUES (3, 'Petar', 'Petrovic', 'petar', '$2a$10$s.eTtPhyBJukkMyB4//Qfu1S0n47t6JeBp9OQglqv9wxcTDQocyUe', 1,
        '+38164561564', 'petar@gmail.com', 'green', '01.01.2018', '06.01.1989');
INSERT INTO User (id, first_name, last_name, username, password, enabled, phone_number, email, color, starting_date,
                  birth_date)
VALUES (4, 'Milan', 'Milosevic', 'milan', '$2a$10$s.eTtPhyBJukkMyB4//Qfu1S0n47t6JeBp9OQglqv9wxcTDQocyUe', 1,
        '+38163489656', 'milan@gmail.com', 'red', '01.01.2020', '06.01.1991');

INSERT INTO AUTHORITIES(USERNAME, AUTHORITY)
VALUES ('mario', 'ROLE_ADMIN');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY)
VALUES ('mario', 'ROLE_USER');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY)
VALUES ('funSte', 'ROLE_USER');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY)
VALUES ('petar', 'ROLE_USER');
INSERT INTO AUTHORITIES(USERNAME, AUTHORITY)
VALUES ('milan', 'ROLE_USER');

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (1, '2021-10-11', '2021-07-22', 'Zoran', 'Jagorinac', '+381638558708', 'zoran.23@gmail.com', 'www.facebook.com',
        '', '', '', 4, 1);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (2, '2020-07-12', '2021-07-22', 'Tamara', 'Obradovic', '+38186521616', 'tamara@gmail.com', 'www.facebook.com',
        '', '', '', 4, 2);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (3, '2020-07-12', '2021-07-22', 'Mario', 'Radivojevic', '+38138965215', 'mario.45641@gmail.com',
        'www.facebook.com', '', '', '', 3, 2);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (4, '2020-07-12', '2021-07-22', 'Stefan', 'Lazovic', '+3885621654', 'stefan@gmail.com', 'www.facebook.com', '',
        '', '', 2, 1);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (5, '2020-07-12', '2021-07-22', 'Radica', 'Petrovic', '+38135668515', 'radica.86@gmail.com', 'www.facebook.com',
        '', '', '', 4, 3);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (6, '2020-07-12', '2021-07-22', 'Petar', 'Ruzmanovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (7, '2020-07-12', '2021-07-22', 'Zivojin', 'Pejovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com', '',
        '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (8, '2020-07-12', '2021-07-22', 'Ivana', 'Obrenovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com', '',
        '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (9, '2020-07-12', '2021-07-22', 'Marija', 'Kuzmanovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (10, '2020-07-12', '2021-07-22', 'Olivera', 'Kuzmanovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (11, '2020-07-12', '2021-07-22', 'Davor', 'Kuzmanovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (12, '2020-07-12', '2021-07-22', 'Marko', 'Rusimovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (13, '2020-07-12', '2021-07-22', 'Milica', 'Kuzmanovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 2, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (14, '2020-07-12', '2021-07-22', 'Jovana', 'Kuzmanovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 3, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (15, '2020-07-12', '2021-07-22', 'Dragana', 'Kuzmanovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (17, '2020-07-12', '2021-07-22', 'Milutin', 'Kuzmanovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (18, '2020-07-12', '2021-07-22', 'Verica', 'Obrenov', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com', '',
        '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (19, '2020-07-12', '2021-07-22', 'Radica', 'Andjelkovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 5, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (20, '2020-07-12', '2021-07-22', 'Milos', 'Petrovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com', '',
        '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (21, '2020-07-12', '2021-07-22', 'Milovan', 'Rusimovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 0, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (22, '2020-07-12', '2021-07-22', 'Jovana', 'Obradovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (23, '2020-07-12', '2021-07-22', 'Vesna', 'Kuzmanovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 1, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (24, '2020-07-12', '2021-07-22', 'Branko', 'Kuzmanovic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 4, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (25, '2020-07-12', '2021-07-22', 'Aleksandar', 'Sremic', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com',
        '', '', '', 4, 4);

INSERT INTO Driver (id, modified, created, first_name, last_name, phone_number, email, link, conformations, residence,
                    schedule, status, user_id)
VALUES (26, '2020-07-12', '2021-07-22', 'Rade', 'Pajser', '+38156126265', 'kuzman@gmail.com', 'www.facebook.com', '',
        '', '', 3, 4);

INSERT INTO Truck (id, truck_id, trailer_number, truck_location, model, insurance, driver_id)
VALUES (1, '123456789', '9876543210', 'London', 'Mercedes', 1, 1);

UPDATE Driver
SET truck_id = 1
WHERE id = 1;

INSERT INTO Load (id, modified, created, date, mileage, distance, status, driver_id)
VALUES (1, '2020-07-12', '2021-07-22', '2021-07-23', 1235.3, 145.5, 1, 1);

INSERT INTO Load (id, modified, created, date, mileage, distance, status, driver_id)
VALUES (2, '2009-06-21', '2021-07-22', '2021-07-23', 1235.3, 145.5, 1, 1);

INSERT INTO Load (id, modified, created, date, mileage, distance, status, driver_id)
VALUES (3, '2021-07-21', '2021-07-22', '2021-07-23', 1235.3, 145.5, 1, 2);

INSERT INTO Load (id, modified, created, date, mileage, distance, status, driver_id)
VALUES (4, '2021-07-21', '2021-07-22', '2021-07-23', 1235.3, 145.5, 1, 1);
