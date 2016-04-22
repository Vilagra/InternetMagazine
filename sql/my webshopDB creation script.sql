USE mywebshop;

DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS orders;


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
INSERT INTO products VALUES(DEFAULT,'tomato',34);

-- ----------
-- orders
-- ----------

CREATE TABLE orders (
  id INT NOT NULL AUTO_INCREMENT,
  date DATETIME NOT NULL,
  PRIMARY KEY (id),
  UNIQUE INDEX id_UNIQUE (id ASC)
);

-- --------------
-- orders_product
-- --------------
CREATE TABLE orders_products (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    product_count INT NOT NULL,
    PRIMARY KEY (order_id,product_id),
    CONSTRAINT FK_ORDER_ID  FOREIGN KEY (order_id) REFERENCES orders(id),
    CONSTRAINT FK_PRODUCT_ID  FOREIGN KEY (product_id) REFERENCES products(id)

);



SELECT * FROM products;

