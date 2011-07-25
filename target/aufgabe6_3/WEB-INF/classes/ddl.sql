USE db_user2;

/*
 * Disable foreign key checks and autocommit,
 * to avoid problems caused by references while
 * dropping and recreating tables.
 */
SET FOREIGN_KEY_CHECKS=0;
SET AUTOCOMMIT=0;
START TRANSACTION;

/*
 * Drop those tables that exist
 */
DROP TABLE IF EXISTS kunden;
DROP TABLE IF EXISTS kunden_adressen;
DROP TABLE IF EXISTS kunden;
DROP TABLE IF EXISTS adressen;
DROP TABLE IF EXISTS kunden_email;
DROP TABLE IF EXISTS kunden_adressen;    

/*
 * (Re-)create all tables.
 */
CREATE TABLE kunden (
    kundennummer INT UNSIGNED NOT NULL AUTO_INCREMENT ,
    nachname VARCHAR( 50 ) CHARACTER SET utf8 NOT NULL ,
    vorname VARCHAR( 50 ) CHARACTER SET utf8 NOT NULL ,
    telefonnummer VARCHAR( 30 ) CHARACTER SET utf8 NOT NULL ,
    email VARCHAR( 50 ) CHARACTER SET utf8,
    PRIMARY KEY ( kundennummer )
)   ENGINE = INNODB,
    CHARACTER SET utf8;

CREATE TABLE kunden_adressen (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    kundennummer INT UNSIGNED NOT NULL ,
    strasse VARCHAR( 50 ) CHARACTER SET utf8 NOT NULL,
    hausnummer VARCHAR( 10 ) CHARACTER SET utf8 NOT NULL,
    plz VARCHAR( 5 ) CHARACTER SET utf8 NOT NULL,
    ort VARCHAR( 50 ) CHARACTER SET utf8 NOT NULL,
    primaer TINYINT ( 1 ) NOT NULL,
    PRIMARY KEY ( id ),
    INDEX ( kundennummer ),
    FOREIGN KEY ( kundennummer )
        REFERENCES kunden( kundennummer )
        ON UPDATE CASCADE ON DELETE CASCADE
)   ENGINE = INNODB,
    CHARACTER SET utf8;

/*
 * Reenable foreign key checks and commit the transaction.
 */
SET FOREIGN_KEY_CHECKS=1;
COMMIT;