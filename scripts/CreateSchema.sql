CREATE DATABASE PassStoreDB;

CREATE TABLE master_login (
    UserID INT NOT NULL AUTO_INCREMENT,
    Username VARCHAR(255) NOT NULL,
    Passwd VARCHAR(255) NOT NULL,
    PRIMARY KEY (UserID)
);

CREATE TABLE login_list (
    Website VARCHAR(255),
    userEmail VARCHAR(255) NOT NULL,
    userPass VARCHAR(255) NOT NULL
);

