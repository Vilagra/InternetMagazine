USE mywebshop;

DROP TABLE IF EXISTS orders_products;
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

INSERT INTO orders VALUES(DEFAULT,'2016-03-15 00:00:00');
INSERT INTO orders VALUES(DEFAULT,'2016-04-02 00:00:00');
INSERT INTO orders VALUES(DEFAULT,'2016-04-07 00:00:00');
INSERT INTO orders VALUES(DEFAULT,'2016-04-15 00:00:00');

-- --------------
-- orders_product
-- --------------
CREATE TABLE orders_products (
    order_id INT NOT NULL,
    product_id INT NOT NULL,
    product_price INT NOT NULL,
    product_count INT NOT NULL,
    PRIMARY KEY (order_id,product_id),
    CONSTRAINT FK_ORDER_ID  FOREIGN KEY (order_id) REFERENCES orders(id),
    CONSTRAINT FK_PRODUCT_ID  FOREIGN KEY (product_id) REFERENCES products(id)

);


INSERT INTO orders_products VALUES(1,2,12,2);
INSERT INTO orders_products VALUES(1,3,17,2);
INSERT INTO orders_products VALUES(2,2,12,2);
INSERT INTO orders_products VALUES(2,4,28,3);
INSERT INTO orders_products VALUES(3,2,14,2);
INSERT INTO orders_products VALUES(3,1,10,15);
INSERT INTO orders_products VALUES(3,4,28,4);
INSERT INTO orders_products VALUES(4,3,18,4);



SELECT * FROM products;
SELECT * FROM orders;
SELECT * FROM orders_products;

