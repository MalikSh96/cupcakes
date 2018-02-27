DROP DATABASE IF EXISTS `cupcakes`;

CREATE DATABASE `cupcakes`;
USE `cupcakes`;

DROP TABLE IF EXISTS `users`;

create table `users` (
`username` varchar(45),
`user_id` int,
`password` varchar(45),
`balance` int
);

create table `admin` (
`admin` varchar(45),
`isAdmin` boolean,
`admin_id` int
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

INSERT INTO bottom (cake_bottom, price, valuta) VALUES ('Chocolate',5,'kr'),('Vanilla',5,'kr'),('Nutmeg',5,'kr'),('Pictacio',6,'kr'),('Almond',7,'kr');

INSERT INTO toppings (cake_topping, price, valuta) VALUES ('Chocolate',5,'kr'),('Blueberry',5,'kr'),('Rasberry',5,'kr'),('Crispy',6,'kr'),('Strawberry',6,'kr'),
('Rum/Raisin',7,'kr'),('Orange',8,'kr'),('Lemon',8,'kr'),('Blue cheese',9,'kr');
