USE mywebshop;

-- ------------
-- products
-- ------------
CREATE TABLE products (
  id INT NOT NULL AUTO_INCREMENT,
  name VARCHAR(45) NOT NULL,
  price INT(8) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC)
);

INSERT INTO products VALUES(DEFAULT,'bread',12);
INSERT INTO products VALUES(DEFAULT,'eggs',22);
INSERT INTO products VALUES(DEFAULT,'milk',17);
INSERT INTO products VALUES(DEFAULT,'tomato',35);

-- ------------
-- test database
-- ------------
SELECT * FROM products;
