CREATE TABLE IF NOT EXISTS tbl_product (
    id  BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO tbl_product(name)VALUES('TV');
INSERT INTO tbl_product(name)VALUES('PC');
INSERT INTO tbl_product(name)VALUES('MONITOR');
INSERT INTO tbl_product(name)VALUES('TECLADO');
INSERT INTO tbl_product(name)VALUES('MOUSE');