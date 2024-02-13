-- BRAND

INSERT INTO inditex.brands (brand_id, brand_name) VALUES (1, 'ZARA');

-- PRODUCT

INSERT INTO inditex.products (product_id, brand_id) VALUES (35455, 1);

-- PRICES

INSERT INTO inditex.PRICES (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (1, 1, '2020-06-14-00.00.00', '2020-12-31-23.59.59', 1, 35455, 0, '35.50', 'EUR');
INSERT INTO inditex.PRICES (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (2, 1, '2020-06-14-15.00.00', '2020-06-14-18.30.00', 2, 35455, 1, '25.45', 'EUR');
INSERT INTO inditex.PRICES (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (3, 1, '2020-06-15-00.00.00', '2020-06-15-11.00.00', 3, 35455, 1, '30.50', 'EUR');
INSERT INTO inditex.PRICES (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr)
VALUES (4, 1, '2020-06-15-16.00.00', '2020-12-31-23.59.59', 4, 35455, 1, '38.95', 'EUR');

