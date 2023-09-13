insert into shoes(id, name, description, price_in_amount, price_in_currency) values
		(gen_random_uuid()::varchar, 'Classic sandal', '', 2500, 'USD'),	
		(gen_random_uuid()::varchar, 'Spring Sneaker', '', 9900, 'EUR')
;

--     id varchar(256) primary key,
--     name varchar(256) not null,
--     description text,
--     price_in_amount integer not null,
--     price_in_currency varchar(3) not null -- e.g. EUR, USD