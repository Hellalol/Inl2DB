drop database if exists shoestoredb;
create database shoestoredb;
use shoestoredb;

CREATE TABLE IF NOT EXISTS category
(
    id            INT         NOT NULL AUTO_INCREMENT,
    category_type VARCHAR(50) not null,
    PRIMARY KEY (id)
);

insert into category (category_type) value ('Sandals'),('Jogging_shoes'), ('Street_shoe'), ('Loafers'),
    ('Boots'),('Hiking_shoe'),('Sneakers'),('Wellingtons');

CREATE TABLE IF NOT EXISTS size
(
    id         INT NOT NULL AUTO_INCREMENT,
    size_value INT NOT NULL not null,
    PRIMARY KEY (id)
);

insert into size (size_value) value (37),(38),(39),(40),(41),(42),(43),(44),(45);

CREATE TABLE IF NOT EXISTS brand
(
    id         INT         NOT NULL AUTO_INCREMENT,
    brand_name VARCHAR(50) not null,
    PRIMARY KEY (id)
);

insert into brand (brand_name) value ('Nike'),('Adidas'),('Icebugs'),('Heelys'),
    ('New Balance'),('Ecco'),('Doc morgans'),('crocs'),('Geccos');

CREATE TABLE IF NOT EXISTS color
(
    id         INT         NOT NULL AUTO_INCREMENT,
    color_name VARCHAR(50) not null,
    PRIMARY KEY (id)
);

insert into color (color_name) value ('Blue'),('Black'),('Brown'),('Pink'),('Yellow'),('Green'),('Red');

create table if not exists price
(
    id           INT NOT NULL AUTO_INCREMENT,
    price_amount int not null,
    PRIMARY KEY (id)
);

insert into price (price_amount)
values (500),
       (800),
       (1000),
       (1500),
       (2000),
       (2200),
       (2500);

CREATE TABLE IF NOT EXISTS product
(
    id       INT NOT NULL AUTO_INCREMENT,
    price_id INT not null,
    color_id INT not null,
    size_id  INT not null,
    brand_id INT not null,
    PRIMARY KEY (id),
    FOREIGN KEY (color_id)
        REFERENCES color (id),
    FOREIGN KEY (size_id)
        REFERENCES size (id),
    FOREIGN KEY (brand_id)
        REFERENCES brand (id),
    FOREIGN KEY (price_id)
        REFERENCES price (id)
);

INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (1, 1, 1, 3);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (1, 1, 2, 3);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (1, 1, 3, 3);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (1, 1, 4, 3);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (2, 2, 1, 2);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (2, 2, 2, 2);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (2, 2, 3, 2);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (2, 2, 4, 2);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (3, 3, 1, 1);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (3, 3, 2, 1);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (3, 3, 3, 1);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (3, 3, 4, 1);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (4, 4, 1, 5);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (4, 4, 2, 5);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (4, 4, 3, 5);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (4, 4, 4, 5);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (5, 5, 1, 3);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (5, 5, 2, 3);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (5, 5, 3, 3);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (5, 5, 4, 3);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (6, 6, 1, 3);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (6, 6, 2, 3);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (6, 6, 3, 3);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (6, 6, 4, 3);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (7, 7, 1, 1);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (7, 7, 2, 1);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (7, 7, 3, 1);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (7, 7, 4, 1);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (8, 1, 1, 6);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (8, 1, 2, 6);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (8, 1, 3, 6);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (8, 1, 4, 6);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (9, 2, 1, 7);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (9, 2, 2, 7);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (9, 2, 3, 7);
INSERT INTO shoestoredb.product (brand_id, color_id, size_id, price_id)
VALUES (9, 2, 4, 7);


CREATE TABLE IF NOT EXISTS city
(
    id        INT         NOT NULL AUTO_INCREMENT,
    city_name VARCHAR(50) not null,
    PRIMARY KEY (id)
);

insert into city (city_name)
values ('Maggås'),
       ('Stockholm'),
       ('Lidingö'),
       ('Ballingslöv'),
       ('Gnarp'),
       ('Göteborg'),
       ('Hammar'),
       ('Halmstad'),
       ('Sanda'),
       ('Stockhult'),
       ('Torp'),
       ('Ubbaboda'),
       ('Ängnäs'),
       ('Örnäs udde'),
       ('Trolleboda'),
       ('Skillinge'),
       ('Anneberg'),
       ('Jukkasjärvi'),
       ('Porjus'),
       ('Sanningslandet'),
       ('Leverhögen'),
       ('Aplungsåsen'),
       ('Rambo'),
       ('Sanningslandet'),
       ('Nördbyn');

CREATE TABLE IF NOT EXISTS postcode
(
    id              INT NOT NULL AUTO_INCREMENT,
    postcode_number INT not null,
    PRIMARY KEY (id)
);

insert into postcode (postcode_number)
values (61231),
       (69112),
       (62711),
       (83055),
       (97732),
       (44586),
       (10346),
       (30736),
       (38694),
       (26773),
       (55226),
       (53102),
       (39308),
       (46006),
       (77757),
       (17337),
       (27695),
       (96509),
       (81793),
       (42088),
       (62272),
       (94674);

CREATE TABLE IF NOT EXISTS adress
(
    id            INT NOT NULL AUTO_INCREMENT,
    adress_name   VARCHAR(50) DEFAULT NULL,
    adress_number INT         default NULL,
    city_id       INT         DEFAULT NULL,
    postcode_id   INT         DEFAULT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (city_id)
        REFERENCES city (id),
    FOREIGN KEY (postcode_id)
        REFERENCES postcode (id)
);

insert into adress (adress_name, adress_number, city_id, postcode_id)
values ('Tivedsvägen', 11, 1, 1),
       ('Bössgränd', 53, 2, 2),
       ('Pite Långvik', 3, 3, 3),
       ('Långgatan', 54, 4, 4),
       ('Norra Bäckebo', 88, 5, 5),
       ('Ellenö', 76, 6, 6),
       ('Kantorsvägen', 25, 7, 7),
       ('Vahlen', 7, 18, 3),
       ('Walton', 95, 15, 4),
       ('Hoffman', 58, 3, 3),
       ('La Follette', 96, 12, 10),
       ('Crowley', 38, 11, 1),
       ('Warrior', 25, 11, 17),
       ('Talmadge', 44, 1, 5),
       ('Myrtle', 68, 23, 10),
       ('GolfView', 28, 13, 13),
       ('Waywood', 31, 22, 22),
       ('Harbort', 22, 20, 21),
       ('Linden', 21, 23, 16),
       ('Ohio', 55, 25, 13),
       ('Johnson', 12, 15, 9),
       ('Scoville', 8, 12, 19),
       ('Surrey', 81, 19, 4),
       ('Onsgard', 19, 18, 18),
       ('Buell', 18, 13, 22);

CREATE TABLE IF NOT EXISTS customer
(
    id         INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name  VARCHAR(50),
    adress_id  int,
    password   varchar(50),
    PRIMARY KEY (id),
    FOREIGN KEY (adress_id)
        REFERENCES adress (id)
        on delete set null
);

insert into customer (first_name, last_name, adress_id, password)
values ('Evelyn', 'Söderberg', 1, 12345),
       ('Freja', 'Göransson', 2, 12345),
       ('Axel', 'Holm', 3, 12345),
       ('Veronika', 'Engström', 4, 12345),
       ('Tor', 'Johnsson', 5, 12345),
       ('Noah', 'Lindgren', 6, 12345),
       ('Blenda', 'Sandberg', 7, 12345),
       ('Janos', 'House', 16, 12345),
       ('Alexandra', 'Cowterd', 23, 12345),
       ('Gare', 'Boniface', 16, 12345),
       ('Ethelyn', 'Cowwell', 10, 12345),
       ('Galvan', 'Pendreigh', 22, 12345),
       ('Tobie', 'Rebichon', 5, 12345),
       ('Guntar', 'Dargie', 24, 12345),
       ('Olin', 'Kitchinham', 11, 12345),
       ('Erminie', 'Dutton', 8, 12345),
       ('Ingaberg', 'Cuncarr', 5, 12345),
       ('Oates', 'Gehricke', 21, 12345),
       ('Ashlen', 'Glowinski', 2, 12345),
       ('Renado', 'Greg', 4, 12345),
       ('Vittoria', 'Moakler', 17, 12345),
       ('Davis', 'Broughton', 15, 12345),
       ('Pat', 'Spensley', 9, 12345),
       ('Nevile', 'Haylands', 5, 12345);

CREATE TABLE IF NOT EXISTS order_item
(
    id         INT NOT NULL AUTO_INCREMENT,
    order_id   int not null,
    product_id int not null,
    quantity   int not null,
    PRIMARY KEY (id),
    foreign key (order_id)
        references product_order (id),
    foreign key (product_id)
        references product (id)
);

INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (1, 5, 3);
INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (2, 1, 1);
INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (3, 2, 1);
INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (5, 1, 1);
INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (6, 2, 1);
INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (7, 5, 1);
INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (1, 4, 5);
INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (2, 4, 1);
INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (2, 4, 1);
INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (32, 4, 1);
INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (33, 6, 1);
INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (34, 4, 1);
INSERT INTO shoestoredb.order_item (order_id, product_id, quantity)
VALUES (35, 3, 1);



CREATE TABLE IF NOT EXISTS product_order
(
    id            INT NOT NULL AUTO_INCREMENT,
    customer_id   int not null,
    date_of_order date,
    primary key (id),
    FOREIGN KEY (customer_id)
        REFERENCES customer (id)
);

INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (1, '2020-01-13');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (2, '2020-01-13');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (3, '2018-04-10');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (4, '2019-12-12');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (5, '2020-01-01');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (6, '2018-02-25');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (2, '2020-01-25');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (2, '2020-01-26');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (2, '2020-01-26');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (2, '2020-01-26');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (2, '2020-01-26');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (2, '2020-01-26');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (2, '2020-01-29');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (2, '2020-01-29');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (1, '2020-01-29');
INSERT INTO shoestoredb.product_order (customer_id, date_of_order)
VALUES (1, '2020-01-29');

CREATE TABLE IF NOT EXISTS lt_shoecategory
(
    id          INT NOT NULL AUTO_INCREMENT,
    product_id  int not null,
    category_id int not null,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id)
        REFERENCES product (id),
    FOREIGN KEY (category_id)
        REFERENCES category (id)
);

insert into lt_shoecategory (product_id, category_id)
values (1, 1),
       (1, 2),
       (2, 2),
       (3, 1),
       (4, 4),
       (5, 5),
       (6, 6),
       (7, 7),
       (8, 8),
       (8, 1),
       (7, 2),
       (10, 4),
       (9, 5);

CREATE TABLE IF NOT EXISTS rating
(
    id           INT NOT NULL AUTO_INCREMENT,
    rating_score int not null,
    rating_text  varchar(50),
    PRIMARY KEY (id)
);

insert into rating (rating_score, rating_text)
values (1, 'Missnöjd'),
       (2, 'Ganska nöjd'),
       (3, 'Nöjd'),
       (4, 'Mycket nöjd'),
       (5, 'Super nöjd');


CREATE TABLE IF NOT EXISTS review
(
    id             INT NOT NULL AUTO_INCREMENT,
    customer_id    INT not null,
    product_id     INT not null,
    rating_id      INT not null,
    review_comment VARCHAR(200),
    date_of_review DATETIME,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id)
        REFERENCES product (id),
    FOREIGN KEY (customer_id)
        REFERENCES customer (id),
    FOREIGN KEY (rating_id)
        REFERENCES rating (id)
);

INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (1, 2, 3, 'Väldigt bra skor', '2019-04-10 21:33:04');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (2, 1, 1, 'Dom var sämst', '2018-05-23 22:22:04');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (4, 1, 2, 'Toppen', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (17, 33, 3, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (14, 2, 2, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (12, 9, 5, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (18, 9, 5, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (19, 33, 3, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (19, 35, 2, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (8, 21, 5, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (22, 5, 5, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (12, 6, 3, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (21, 9, 4, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (13, 8, 2, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (8, 15, 3, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (2, 8, 1, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (22, 14, 4, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (16, 7, 5, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (13, 16, 4, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (15, 23, 4, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (21, 3, 3, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (8, 35, 5, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (5, 16, 1, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (10, 12, 2, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (20, 12, 3, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (20, 14, 5, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (17, 9, 2, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (11, 12, 5, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (12, 30, 1, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (12, 22, 4, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (6, 20, 1, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (8, 13, 2, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (7, 4, 1, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (9, 13, 1, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (16, 17, 1, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (7, 11, 1, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (13, 6, 5, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (13, 24, 1, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (15, 15, 1, '-review text-', '2020-01-26 14:27:10');
INSERT INTO shoestoredb.review (customer_id, product_id, rating_id, review_comment, date_of_review)
VALUES (4, 14, 4, '-review text-', '2020-01-26 14:27:10');



CREATE TABLE IF NOT EXISTS stock
(
    id           INT NOT NULL AUTO_INCREMENT,
    shoe_id      int,
    stock_amount int,
    PRIMARY KEY (id),
    FOREIGN KEY (shoe_id)
        REFERENCES product (id)
);

INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (1, 2);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (2, 4);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (3, 0);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (4, 0);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (5, 3);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (6, 0);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (7, 2);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (8, 3);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (9, 1);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (10, 5);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (11, 6);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (12, 7);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (13, 4);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (14, 3);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (15, 6);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (16, 9);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (17, 4);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (18, 2);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (19, 3);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (20, 4);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (21, 4);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (22, 5);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (23, 6);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (24, 2);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (25, 0);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (26, 0);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (27, 0);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (28, 2);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (29, 3);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (30, 4);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (31, 5);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (32, 4);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (33, 1);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (34, 1);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (35, 1);
INSERT INTO shoestoredb.stock (shoe_id, stock_amount)
VALUES (36, 1);



CREATE TABLE IF NOT EXISTS notinstock
(
    id         INT NOT NULL AUTO_INCREMENT,
    product_id int,
    datetime   datetime,
    PRIMARY KEY (id),
    FOREIGN KEY (product_id)
        REFERENCES product (id)
);

INSERT INTO shoestoredb.notinstock (product_id, date_time)
VALUES (6, '2020-01-26 17:09:07');
INSERT INTO shoestoredb.notinstock (product_id, date_time)
VALUES (3, '2020-01-28 20:04:36');
INSERT INTO shoestoredb.notinstock (product_id, date_time)
VALUES (4, '2020-01-29 03:14:43');
INSERT INTO shoestoredb.notinstock (product_id, date_time)
VALUES (6, '2020-01-29 03:14:43');
INSERT INTO shoestoredb.notinstock (product_id, date_time)
VALUES (4, '2020-01-29 04:18:33');
INSERT INTO shoestoredb.notinstock (product_id, date_time)
VALUES (3, '2020-01-29 04:21:59');