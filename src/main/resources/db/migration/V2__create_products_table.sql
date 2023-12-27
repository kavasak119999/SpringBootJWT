CREATE TABLE IF NOT EXISTS products
(
    id           BIGINT AUTO_INCREMENT PRIMARY KEY,
    entry_date    VARCHAR(20),
    item_code     INT,
    item_name     VARCHAR(255),
    item_quantity INT,
    status       VARCHAR(255)
);