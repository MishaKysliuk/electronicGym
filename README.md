Hello! You visited electronic gym project created by Misha Kysliuk.
There are three roles in this system: Administrator, Trainer and Client. The system provides the communication between client and his trainer via web application. Client has got possibility to buy gym pass, fill his personal card, choose trainer and then order a training that will be created by his trainer.
Trainer hass got possibilities to create exercises and create workouts for his clients.
Administrator has got possibilities to register trainer, manage gym pass inventory and he has a view of trainers and clients list.

To clone this project you need to run the sql command below first:

create database egym;
use egym;
create table users(
username varchar_ignorecase(50) not null primary key,
password varchar_ignorecase(50) not null,
enabled boolean not null
);

create table authorities (
username varchar_ignorecase(50) not null,
authority varchar_ignorecase(50) not null,
constraint fk_authorities_users foreign key(username) references users(username)
);
