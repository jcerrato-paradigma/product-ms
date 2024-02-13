-- SCHEMA CREATION

CREATE SCHEMA IF NOT EXISTS inditex;

-- TABLES

CREATE TABLE IF NOT EXISTS inditex.brands (
    brand_id INTEGER NOT NULL,
    brand_name VARCHAR(200) NOT NULL
);

CREATE TABLE IF NOT EXISTS inditex.products (
    product_id BIGINT NOT NULL,
    brand_id INTEGER NOT NULL
);

CREATE TABLE IF NOT EXISTS inditex.prices (
    price_id BIGINT NOT NULL,
    brand_id INTEGER NOT NULL,
    start_date VARCHAR(19) NOT NULL,
    end_date VARCHAR(19) NOT NULL,
    price_list INTEGER NOT NULL,
    product_id BIGINT NOT NULL,
    priority INTEGER DEFAULT 1,
    price VARCHAR(200) NOT NULL,
    curr VARCHAR(10) NOT NULL
    );

-- CONSTRAINTS

ALTER TABLE inditex.brands
ADD CONSTRAINT pk_brand PRIMARY KEY (brand_id);

ALTER TABLE inditex.products
ADD CONSTRAINT pk_product PRIMARY KEY (product_id, brand_id);

ALTER TABLE inditex.products
ADD CONSTRAINT fk_brand_product
FOREIGN KEY (brand_id)
REFERENCES inditex.brands(brand_id);

ALTER TABLE inditex.prices
ADD CONSTRAINT pk_prices PRIMARY KEY (price_id);

ALTER TABLE inditex.prices
ADD CONSTRAINT fk_prices_brand
FOREIGN KEY (brand_id)
REFERENCES inditex.brands(brand_id);

ALTER TABLE inditex.prices
ADD CONSTRAINT fk_prices_product
FOREIGN KEY (product_id)
REFERENCES inditex.products(product_id);
