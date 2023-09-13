create table variants (
	sku varchar(256) primary key,
	shoe_id varchar(256) not null,
	label text not null,
	size varchar(128) not null
	color varchar(128) not null
	constraint fk_shoe 
		FOREIGN KEY(shoe_id)
			REFERENCES shoes(id)
);

create index if not exists v_size on variants(size);
create index if not exists v_color on variants(color);