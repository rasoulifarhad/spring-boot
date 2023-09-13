create table shoes (
	id varchar(256) primary key,
	name varchar(256) not null,
	description text,
	price_in_amount integer not null,
	price_in_currency varchar(3) not null,
	constraint price_non_neg check (price_in_amount >= 0)
);