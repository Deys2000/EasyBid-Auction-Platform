CREATE TABLE IF NOT EXISTS shipment.shipment (
    id INTEGER AUTO_INCREMENT,
    item_id INTEGER NOT NULL,
    carrier varchar(50) NOT NULL,
    shipping_time DATETIME NOT NULL,
    shipping_status varchar(50) NOT NULL,
    PRIMARY KEY (id)
);
