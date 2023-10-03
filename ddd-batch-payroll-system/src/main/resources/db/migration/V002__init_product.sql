create table IF NOT EXISTS products 
(
    id bigint not null ,
    name varchar(255) not null,
    primary key (id)
);

create table IF NOT EXISTS invoices 
(
    id bigint not null ,
    number varchar(255) not null,
    primary key (id)
);

create table IF NOT EXISTS invoice_line_items
(
    invoice_id bigint not null ,
    product_id bigint not null ,
    line_items_row integer not null,
    quantity integer not null
);

ALTER TABLE invoice_line_items ADD FOREIGN KEY (invoice_id) REFERENCES invoices;
ALTER TABLE invoice_line_items ADD FOREIGN KEY (product_id) REFERENCES products;

insert into products(id, name) values (1, 'ProductA');
insert into products(id, name) values (2, 'ProductB');

insert into invoices(id, number) values (1, 'Invoice-01');


insert into invoice_line_items(invoice_id, product_id, line_items_row, quantity) 
values (1, 1, 1, 4);
insert into invoice_line_items(invoice_id, product_id, line_items_row, quantity) 
values (1, 2, 2, 8);
