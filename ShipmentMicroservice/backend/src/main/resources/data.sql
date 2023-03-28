TRUNCATE TABLE shipment.shipment;
INSERT INTO shipment.shipment (item_id, carrier, shipping_time, shipping_status)
VALUES (12345, 'UPS', STR_TO_DATE('2023-03-25 10:30:00', '%Y-%m-%d %H:%i:%s'), 'Shipped' );

