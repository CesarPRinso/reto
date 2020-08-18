DROP DATABASE IF EXISTS experis;
create database experis;
create user 'experis' identified by 'experis';
grant all on experis.* to 'experis';
USE experis;

CREATE TABLE IF NOT EXISTS CUSTOMERS(		
	ID BIGINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,	
	NAME VARCHAR(255),	 
    LASTNAME VARCHAR(255),
    EMAIL VARCHAR(255),
    DNI VARCHAR(8),
    CREATIONDATE DATE,
    BIRTHDATE DATE);
