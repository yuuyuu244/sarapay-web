create database webapp;
use webapp;
create table user(
	id varchar(40),
	password varchar(40),
	PRIMARY KEY (id)
);

insert into user values ("idok", "passok");