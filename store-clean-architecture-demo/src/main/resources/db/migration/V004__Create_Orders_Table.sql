create table orders (
    id varchar(256) primary key ,
    user_name varchar(256) not null,
    user_email text not null,
    time_placed timestamp with time zone not null,
    total_price_amount int,
    total_price_currency varchar(3)
);
create index if not exists orders_user on orders(user_email);



create table order_line_items(
    order_id varchar(256) not null,
    position int not null,
    sku varchar(256) not null,
    price_per_amount int not null,
    price_per_currency varchar(3) not null,
    serial_numbers text[],

    constraint fk_line_order
        foreign key (order_id)
            references orders(id),

    constraint fk_line_sku
        foreign key (sku)
            references  variants(sku)

);