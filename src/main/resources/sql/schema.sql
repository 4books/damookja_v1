-- schema.sql
CREATE TABLE item (
    item_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    stock_count int,
    price DECIMAL(19, 2),
    created_time DATETIME
);