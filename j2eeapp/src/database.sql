create table appuser (

	id number,
	firstName varchar(20),
	lastName varchar(20),
	userName varchar(20),
	password varchar(33),
	constraint appuser_pk primary key (id),
	constraint appuser_username_uk unique (userName)
	
);
