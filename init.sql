CREATE Database IF NOT EXISTS todolist;
USE todolist;

CREATE TABLE notes(
                                    id int AUTO_INCREMENT PRIMARY KEY,
                                    name varchar(50),
                                    note text
);

