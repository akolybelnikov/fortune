DROP TABLE IF EXISTS quote;
CREATE TABLE quote
(
    id       INTEGER      NOT NULL AUTO_INCREMENT,
    quote    LONGTEXT NOT NULL,
    PRIMARY KEY (id)
);