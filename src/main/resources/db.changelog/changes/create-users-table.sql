CREATE TABLE IF NOT EXISTS users (
                                     id bigint NOT NULL AUTO_INCREMENT,
                                     email varchar(255) DEFAULT NULL UNIQUE,
    first_name varchar(255) DEFAULT NULL,
    last_name varchar(255) DEFAULT NULL,
    birth_date DATE DEFAULT NULL,
    address varchar(255) DEFAULT NULL,
    PRIMARY KEY (id)
    );