CREATE TABLE IF NOT EXISTS products  (
  id bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name nvarchar(100) NULL,
  description nvarchar(2000) NULL,
  price decimal(10, 2) NULL,
  is_on_sale boolean
);