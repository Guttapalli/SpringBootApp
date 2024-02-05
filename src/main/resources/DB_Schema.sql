
CREATE DATABASE shopping;

CREATE SCHEMA shopping
     AUTHORIZATION sarath;

DROP  TABLE IF EXISTS shopping.products

CREATE SEQUENCE products_seq;

CREATE TABLE shopping.products (
  key  SERIAL NOT NULL ,
  name varchar(25) NOT NULL,
  quantity int,
  available int,
  mrp_price decimal,
  category_id varchar(25),
  PRIMARY KEY(key)

);

DROP  TABLE IF EXISTS shopping.sales

CREATE TABLE shopping.sales(
    id SERIAL ,
    total_amount decimal ,
    date TIMESTAMP,
    PRIMARY KEY (id)

);

DROP  TABLE IF EXISTS shopping.sale_items


CREATE TABLE shopping.sale_items(
    id SERIAL,
    order_id int ,
    product_id int,
    quantity int ,
    amount decimal,
    PRIMARY KEY(id),
    FOREIGN KEY (order_id)  REFERENCES shopping.sales(id ),
    FOREIGN KEY (product_id) REFERENCES shopping.products(key)

);

INSERT INTO shopping.products ( name ,available,quantity,mrp_price,category_id)
VALUES ( 'black dog', 23,90,'1' );

INSERT INTO shopping.sales ( total_amount ,date)
VALUES ( 456 ,'2022-10-10 11:30:30' );

INSERT INTO shopping.sale_items (order_id, product_id ,quantity,amount)
VALUES (1, 1, 4 ,3456 );


select * FROM shopping.products ;

select * FROM shopping.sales ;

select * FROM shopping.sale_items ;

select p1_0.product_id,p1_0.category,p1_0.name,p1_0.price,p1_0.quantity from shopping.products p1_0 where p1_0.name='FM jeans';




