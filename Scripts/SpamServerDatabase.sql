create database SpamServer;

use SpamServer;


create table users(
id integer auto_increment not null primary key,
name varchar(255) default null,
date_created datetime not null,
password varchar(4000) not null,
);

create table emails(
id integer auto_increment not null primary key,
filename varchar(255) default null,
probability double default null,
date_time_of_scan datetime default null,
scanned_user_id integer default null,
foreign key (scanned_user_id) references users(id)
);

create user spamserver@localhost identified by 'password';

grant SELECT,INSERT,UPDATE,DELETE on SpamServer.* to spamserver@localhost;