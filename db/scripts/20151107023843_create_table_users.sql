-- // create table users
-- Migration SQL that makes the change goes here.
CREATE TABLE USERS(
id VARCHAR(255) PRIMARY KEY ,
username VARCHAR(100) NOT NULL UNIQUE ,
password VARCHAR(100) NOT NULL
)


-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE USERS

