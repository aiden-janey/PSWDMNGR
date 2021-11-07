CREATE DATABASE PassStoreDB;

CREATE TABLE master_login (
    userid INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    passwd VARCHAR(255) NOT NULL,
    PRIMARY KEY (userid)
);

CREATE TABLE login_list (
    website VARCHAR(255),
    useremail VARCHAR(255) NOT NULL,
    userpass VARCHAR(255) NOT NULL
);

