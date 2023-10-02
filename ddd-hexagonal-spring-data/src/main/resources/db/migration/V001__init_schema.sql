create table users 
(
    id bigint not null ,
    name varchar(255) not null,
    address  varchar(255) not null,
    primary key (id)
);

insert into users(id, name, address) values (1, 'name 1', 'address 1');
