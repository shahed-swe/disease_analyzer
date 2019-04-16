create database disease_analyzer

create table admin(
	admin_id int(100),
	first_name varchar(100),
	last_name varchar(100),
	user_name varchar(100),
	email varchar(100),
	password varchar(100),
	age varchar(100),
	address varchar(100),
	phone varchar(100)
);

create table user(
	user_id int(100),
	first_name varchar(100),
	last_name varchar(100),
	user_name varchar(100),
	email varchar(100),
	password varchar(100),
	age varchar(100),
	address varchar(100),
	phone varchar(100)
);

create table doctor(
	doctor_id int(100),
	first_name varchar(100),
	last_name varchar(100),
	user_name varchar(100),
	email varchar(100),
	password varchar(100),
	age varchar(100),
	address varchar(100),
	phone varchar(100)
);