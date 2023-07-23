DROP TABLE IF  EXISTS users;
CREATE TABLE users
(
    id           UUID PRIMARY KEY,
    phone_number VARCHAR(100) NOT NULL UNIQUE
);