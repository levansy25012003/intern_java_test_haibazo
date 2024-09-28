CREATE DATABASE product_service;
use product_service;

CREATE TABLE category (
    category_id     INT PRIMARY KEY AUTO_INCREMENT,
    category_name   VARCHAR(255) NOT NULL
);

CREATE TABLE style (
    style_id    INT PRIMARY KEY AUTO_INCREMENT,
    style_name  varchar(255) NOT NULL
);

CREATE TABLE size (
    size_id     INT PRIMARY KEY AUTO_INCREMENT,
    size_name   VARCHAR(10) NOT NULL
);

CREATE TABLE color (
    color_id    INT PRIMARY KEY AUTO_INCREMENT,
    color_name  VARCHAR(50) NOT NULL,
    color_code  VARCHAR(7)
);

CREATE TABLE product (
    id              INT PRIMARY KEY AUTO_INCREMENT,
    name            VARCHAR(100) NOT NULL,
    description     TEXT,
    rating          DECIMAL(3,2),
    price           INT,
    original_price  INT,
    review_count    INT,
    discount_end    DATETIME,
    quantity        INT,
    category_id     INT,
    style_id        INT,
    FOREIGN KEY (category_id) REFERENCES category(category_id),
    FOREIGN KEY (style_id) REFERENCES style(style_id)
);

CREATE TABLE image (
    image_id        INT PRIMARY KEY AUTO_INCREMENT,
    image_url       VARCHAR(255) NOT NULL,
    product_id      INT,
    FOREIGN KEY (product_id) REFERENCES product (id)
);

CREATE TABLE product_color (
    color_id    INT,
    product_id  INT,
    PRIMARY KEY (color_id, product_id),
    FOREIGN KEY (color_id) REFERENCES color(color_id),
    FOREIGN KEY (product_id) REFERENCES product(id)
);
CREATE TABLE product_size (
     size_id INT,
     product_id  INT,
     PRIMARY KEY (size_id, product_id),
     FOREIGN KEY (size_id) REFERENCES size(size_id) ,
     FOREIGN KEY (product_id) REFERENCES product(id)
);

# INSERT DATA
INSERT INTO category (category_name)
VALUES ('Home & Decor'),
       ('Clothing'),
       ('Accessories'),
       ('Outdoor');
INSERT INTO style (style_name)
VALUES ('Modern'),
       ('Streetwear'),
       ('Colorfull'),
       ('Patchwork'),
       ('Bohemian'),
       ('Vintage');
INSERT INTO size (size_name)
VALUES ('S'),
       ('M'),
       ('L'),
       ('XL'),
       ('2XL');
INSERT INTO color (color_name, color_code)
VALUES ('green', '#0c7806'),
       ('purple', '#bc00bf'),
       ('red', '#e80920'),
       ('black', '#000000');

# INSERT INTO product
INSERT INTO product (name, description, rating, price, original_price, review_count, discount_end, quantity, category_id, style_id)
VALUES
    ('Decorative Vase', 'Elegant home decor vase', 4.5, 250, 300, 15, '2024-12-31 23:59:59', 50, 1, 1),
    ('Modern Lamp', 'Stylish modern table lamp', 4.8, 120, 150, 20, '2024-11-15 23:59:59', 80, 1, 1),
    ('Leather Jacket', 'High-quality streetwear leather jacket', 4.7, 550, 700, 120, '2024-10-30 23:59:59', 100, 2, 2),
    ('Sunglasses', 'Trendy summer sunglasses', 4.2, 80, 100, 200, '2024-09-30 23:59:59', 300, 3, 2),
    ('Bohemian Dress', 'Colorful bohemian dress', 4.9, 250, 300, 80, '2024-10-15 23:59:59', 150, 2, 5),
    ('Vintage Clock', 'Beautiful vintage wall clock', 4.4, 200, 250, 50, '2024-12-01 23:59:59', 60, 1, 6),
    ('Outdoor Tent', 'Durable outdoor tent for camping', 4.6, 300, 400, 60, '2024-10-20 23:59:59', 90, 4, 2),
    ('Patchwork Quilt', 'Handmade patchwork quilt', 4.7, 450, 500, 30, '2024-12-25 23:59:59', 20, 1, 4),
    ('Running Shoes', 'Comfortable running shoes', 4.3, 120, 150, 90, '2024-09-30 23:59:59', 220, 2, 2),
    ('Boho Earrings', 'Stylish bohemian earrings', 4.1, 60, 80, 150, '2024-11-05 23:59:59', 180, 3, 5),
-- More products (Total 30)
    ('Smart Watch', 'Smart watch with fitness tracking', 4.8, 300, 400, 200, '2024-10-01 23:59:59', 500, 2, 1),
    ('Casual T-shirt', 'Classic white casual t-shirt', 4.2, 40, 60, 300, '2024-09-20 23:59:59', 1000, 2, 2),
    ('Office Chair', 'Ergonomic office chair', 4.9, 220, 300, 180, '2024-10-30 23:59:59', 100, 1, 1),
    ('Vintage Sunglasses', 'Classic vintage sunglasses', 4.5, 100, 120, 150, '2024-09-30 23:59:59', 400, 3, 6),
    ('Camping Backpack', 'Durable outdoor backpack for camping', 4.7, 150, 180, 50, '2024-12-10 23:59:59', 250, 4, 2),
    ('Floral Skirt', 'Bright and floral skirt', 4.3, 80, 100, 130, '2024-11-20 23:59:59', 200, 2, 5),
    ('Wall Art', 'Modern wall art for home decoration', 4.6, 120, 150, 100, '2024-12-25 23:59:59', 80, 1, 1),
    ('Streetwear Hoodie', 'Comfortable streetwear hoodie', 4.5, 70, 90, 90, '2024-11-10 23:59:59', 300, 2, 2),
    ('Handmade Necklace', 'Handmade vintage necklace', 4.8, 200, 250, 40, '2024-12-15 23:59:59', 30, 3, 6),
    ('Biker Jacket', 'Stylish leather biker jacket', 4.7, 400, 500, 50, '2024-11-30 23:59:59', 90, 2, 2),
    ('Winter Boots', 'Warm winter boots for outdoors', 4.3, 160, 200, 70, '2024-10-25 23:59:59', 120, 4, 2),
    ('Decorative Pillows', 'Soft pillows with colorful designs', 4.2, 50, 70, 80, '2024-12-05 23:59:59', 150, 1, 4),
    ('Boho Hat', 'Stylish bohemian sun hat', 4.6, 70, 100, 60, '2024-10-10 23:59:59', 90, 3, 5),
    ('Outdoor Lantern', 'Durable outdoor lantern for camping', 4.8, 90, 120, 30, '2024-10-15 23:59:59', 100, 4, 2),
    ('Floral Dress', 'Light and bright floral dress', 4.7, 120, 150, 80, '2024-11-05 23:59:59', 200, 2, 5),
    ('Men\'s Watch', 'Elegant watch for men', 4.9, 300, 350, 90, '2024-09-28 23:59:59', 50, 3, 1),
    ('Patchwork Bag', 'Handmade patchwork bag', 4.5, 80, 100, 40, '2024-12-20 23:59:59', 70, 3, 4),
    ('Winter Scarf', 'Warm winter scarf', 4.2, 40, 60, 100, '2024-10-30 23:59:59', 150, 3, 2);

# INSERT INTO image
INSERT INTO image (image_url, product_id)
VALUES
    ('https://example.com/images/vase.jpg', 1),
    ('https://example.com/images/lamp.jpg', 2),
    ('https://example.com/images/jacket.jpg', 3),
    ('https://example.com/images/sunglasses.jpg', 4),
    ('https://example.com/images/dress.jpg', 5),
    ('https://example.com/images/clock.jpg', 6),
    ('https://example.com/images/tent.jpg', 7),
    ('https://example.com/images/quilt.jpg', 8),
    ('https://example.com/images/shoes.jpg', 9),
    ('https://example.com/images/earrings.jpg', 10),
-- More images for other products
    ('https://example.com/images/smartwatch.jpg', 11),
    ('https://example.com/images/tshirt.jpg', 12),
    ('https://example.com/images/chair.jpg', 13),
    ('https://example.com/images/vintage_sunglasses.jpg', 14),
    ('https://example.com/images/backpack.jpg', 15),
    ('https://example.com/images/skirt.jpg', 16),
    ('https://example.com/images/wall_art.jpg', 17),
    ('https://example.com/images/hoodie.jpg', 18),
    ('https://example.com/images/necklace.jpg', 19),
    ('https://example.com/images/biker_jacket.jpg2', 1),
    ('https://example.com/images/biker_jacket.jpg3', 1),
    ('https://example.com/images/biker_jacket.jpg4', 1),
    ('https://example.com/images/biker_jacket.jpg5', 1),
    ('https://example.com/images/biker_jacket.jpg2', 2),
    ('https://example.com/images/biker_jacket.jpg3', 2),
    ('https://example.com/images/biker_jacket.jpg4', 2),
    ('https://example.com/images/biker_jacket.jpg5', 2);

# INSERT INTO product_color
INSERT INTO product_color (color_id, product_id)
VALUES
    (1, 1), (2, 1), (3, 2), (4, 3), (2, 3),
    (1, 4), (3, 5), (4, 6), (1, 7), (2, 8),
    (3, 9), (4, 10), (1, 11), (2, 12), (3, 13),
    (4, 14), (1, 15), (2, 16), (3, 17), (4, 18),
    (1, 19), (2, 20), (3, 21), (4, 22), (1, 23),
    (2, 24), (3, 25), (4, 26), (1, 27), (2, 28);

# INSERT INTO product_size
INSERT INTO product_size (size_id, product_id)
VALUES
    (1, 1), (2, 2), (3, 3), (4, 4), (5, 5),
    (1, 6), (2, 7), (3, 8), (4, 9), (5, 10),
    (1, 11), (2, 12), (3, 13), (4, 14), (5, 15),
    (1, 16), (2, 17), (3, 18), (4, 19), (5, 20),
    (1, 21), (2, 22), (3, 23), (4, 24), (5, 25),
    (1, 26), (2, 27), (3, 28), (4, 27), (5, 28),
    (2, 1), (3, 1), (4, 1), (2, 3), (3, 4), (4, 5);
