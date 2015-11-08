-- // create container table
-- Migration SQL that makes the change goes here.
CREATE TABLE containers(
id VARCHAR(255) NOT NULL PRIMARY KEY,
userid VARCHAR(255) NOT NULL,
image VARCHAR(255) NOT NULL,
name VARCHAR(100) not NULL,
command VARCHAR(100),
create_at DATE,
status VARCHAR(10),
port INTEGER,
host_port INTEGER
)


-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE containers

