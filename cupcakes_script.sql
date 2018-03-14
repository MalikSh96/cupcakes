DROP DATABASE IF EXISTS `cupcakes`;

CREATE DATABASE `cupcakes`;

USE `cupcakes`;

DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `bottom`;
DROP TABLE IF EXISTS `orderline`;
DROP TABLE IF EXISTS `toppings`;
DROP TABLE IF EXISTS `orders`;

create table `users` (
`username` varchar(45),
`user_id` int auto_increment primary key,
`password` varchar(45),
`balance` int,
`isAdmin` boolean
);


create table `bottom` (
`id` int AUTO_INCREMENT primary key,
`cake_bottom` varchar(45) not null,
`price` int not null,
`valuta` varchar(45) DEFAULT NULL
);


create table `toppings` (
`id` int AUTO_INCREMENT primary key,
`cake_topping` varchar(45) not null,
`price` int not null,
`valuta` varchar(45) DEFAULT NULL
);

create table `orders` (
`id` int auto_increment primary key,
userOrderID int not null,
FOREIGN KEY (userOrderID) REFERENCES users(`user_id`),
`dates` datetime default current_timestamp
);

create table `orderline` (
`toppings_id` int not null,
`bottom_id` int not null,
`qty` int not null,
orders_id int not NULL,
FOREIGN KEY (orders_id) REFERENCES orders(`id`),
FOREIGN KEY (toppings_id) REFERENCES toppings(`id`),
FOREIGN KEY (bottom_id) REFERENCES bottom(`id`),
primary key (orders_id)
);

INSERT into users (username, password, balance, isAdmin) VALUES ('Malik', '5555', 1000, true);

INSERT INTO bottom (cake_bottom, price, valuta) VALUES ('Chocolate',5,'kr'),('Vanilla',5,'kr'),('Nutmeg',5,'kr'),('Pictacio',6,'kr'),('Almond',7,'kr');

INSERT INTO toppings (cake_topping, price, valuta) VALUES ('Chocolate',5,'kr'),('Blueberry',5,'kr'),('Rasberry',5,'kr'),('Crispy',6,'kr'),('Strawberry',6,'kr'),
('Rum/Raisin',7,'kr'),('Orange',8,'kr'),('Lemon',8,'kr'),('Blue cheese',9,'kr');

-- INSERT INTO orderline (toppings_id, bottom_id, qty, orders_id) VALUES (1,2,3,2);