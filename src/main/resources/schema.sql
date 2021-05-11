DROP TABLE IF EXISTS catalog;

CREATE TABLE catalog
(
  id number not null
  AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR
  (250) NOT NULL,
  description VARCHAR
  (250) NOT NULL,
  referenceId VARCHAR
  (250) NOT NULL UNIQUE

);

DROP TABLE IF EXISTS item;
CREATE TABLE item
(
  id number not null
  AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR
  (250) NOT NULL,
  description VARCHAR
  (250) NOT NULL,
  referenceId VARCHAR
  (250) NOT NULL UNIQUE,
  price number,
  catalogId number not null,
   FOREIGN KEY (catalogId) REFERENCES catalog(id)

);


