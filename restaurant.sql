create database restaurant;

use restaurant;

create table user(
 name varchar(20),
 password varchar(10)
 );
 select * from user;
 insert into user values("user1","pwd1");
 insert into user values("user2","pwd2");
 insert into user values("user3","pwd3");
 
 create table admin(
 name varchar(20),
 password varchar(10)
 );
 select * from admin;
 insert into admin values("admin1","pwd1");
 
 
 create table menu(
 itemname varchar(20),
 price int
 );
 
 insert into menu values ("Full Meal", 100);
 insert into menu values ("Curd Rice",75);
 insert into menu values ("Maggi",30);
 insert into menu values ("Fried rice",50);
 insert into menu values ("Veg Noodles",60);
 insert into menu values ("Chicken Noodles",75);
 insert into menu values ("Sambar Rice",50);
 
 select * from menu;
 
 create table bills(
username varchar(20),
item varchar(20),
price int,
date date
);

insert into bills values("user1", "Full Meals", 100, "2021/07/08");
insert into bills values("user2", "Chicken Noodles", 75, "2021/07/08");
insert into bills values("user3", "Fried Rice", 50, "2021/08/08");
insert into bills values("user1", "Full Meals", 100, "2021/08/08");
insert into bills values("user3", "Fried Rice", 50, "2021/08/09");
insert into bills values("user1", "Full Meals", 100, "2021/08/09");

select * from bills;