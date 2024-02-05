CREATE TABLE IF NOT EXISTS shopping.products
(
    key smallint,
    name character varying(8) DEFAULT NULL::character varying,
    mrp_price smallint,
    available smallint,
    quantity smallint,
    category_id character varying(1) DEFAULT NULL::character varying
)