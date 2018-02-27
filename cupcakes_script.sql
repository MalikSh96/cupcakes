DROP DATABASE IF EXISTS `cupcakes`;

CREATE DATABASE `cupcakes`;
USE `cupcakes`;

DROP TABLE IF EXISTS `users`;

create table `users` (
`username` varchar(45),
`user_id` int auto_increment primary key,
`password` varchar(45),
`balance` int
);

create table `admin` (
`admin` varchar(45),
`isAdmin` boolean,
`admin_id` int auto_increment primary key
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

INSERT into users (username, password, balance) VALUES ('Anders And', '1234', 200),('Mickey Mouse', '4321', 100),('Malik', '5555', 1000);

INSERT into admin (admin, isAdmin) VALUES ('Malik', true);

INSERT INTO bottom (cake_bottom, price, valuta) VALUES ('Chocolate',5,'kr'),('Vanilla',5,'kr'),('Nutmeg',5,'kr'),('Pictacio',6,'kr'),('Almond',7,'kr');

INSERT INTO toppings (cake_topping, price, valuta) VALUES ('Chocolate',5,'kr'),('Blueberry',5,'kr'),('Rasberry',5,'kr'),('Crispy',6,'kr'),('Strawberry',6,'kr'),
('Rum/Raisin',7,'kr'),('Orange',8,'kr'),('Lemon',8,'kr'),('Blue cheese',9,'kr');
