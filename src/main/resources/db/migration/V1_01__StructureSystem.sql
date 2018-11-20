DROP TABLE IF EXISTS PUBLIC."user";
CREATE TABLE PUBLIC."user"
(
	"id"					SERIAL PRIMARY KEY,
	"user_name"				VARCHAR(64),
	"email"					VARCHAR(128),
	"password"				VARCHAR(256),
	"first_name"			VARCHAR(32),
	"last_name"				VARCHAR(32)
);

DROP TABLE IF EXISTS PUBLIC."hero";
CREATE TABLE PUBLIC."hero"
(
	"id"					SERIAL PRIMARY KEY,
	"name"					VARCHAR(64)
);
