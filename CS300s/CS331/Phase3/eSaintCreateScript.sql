-- Create the database
DROP SCHEMA IF EXISTS OneHitWonders;
CREATE SCHEMA IF NOT EXISTS OneHitWonders;

-- use the created database
USE OneHitWonders;

-- ADMINISTRATOR
CREATE TABLE		ADMINISTRATOR (
  USER_ID		INTEGER 		NOT NULL 	AUTO_INCREMENT,
  USERNAME		VARCHAR(15) 	NOT NULL,
  PASSWORD		VARCHAR(30) 	NOT NULL,

  PRIMARY KEY 	(USER_ID)
)ENGINE=InnoDB;

-- USER
CREATE TABLE		USERS (
  USER_ID 		INTEGER 		NOT NULL 	AUTO_INCREMENT,
  USERNAME 		VARCHAR(15) 	NOT NULL,
  PASSWORD 		VARCHAR(30) 	NOT NULL,
  EMAIL 		VARCHAR(60) 	NOT NULL,
  PHONE_NUMBER 	CHAR(10)		NOT NULL,
  FIRST_NAME	VARCHAR(25)		NOT NULL,
  LAST_NAME		VARCHAR(25)		NOT NULL,
  CARD_NUMBER	CHAR(16)		NOT NULL,
  CARD_TYPE		VARCHAR(10)		NOT NULL,
  CARD_EXP_MON	CHAR(2)			NOT NULL,
  CARD_EXP_YR	CHAR(4)			NOT NULL,
  CREATOR_ID	INTEGER			NOT NULL,
  
  PRIMARY KEY	(USER_ID),
  CONSTRAINT UNIQUE_CARD UNIQUE		(CARD_NUMBER),  
  CONSTRAINT CREATED_BY_FK FOREIGN KEY	(CREATOR_ID) 	REFERENCES ADMINISTRATOR (USER_ID) ON UPDATE CASCADE
)ENGINE=InnoDB;

ALTER TABLE USERS ADD CONSTRAINT CARD_NOT_EXPIRED CHECK ( CARD_EXP_MON >= MONTH(NOW()) AND CARD_EXP_YR >= YEAR(NOW()) );

-- ITEM
CREATE TABLE		ITEM (
  ITEM_ID			INTEGER			NOT NULL 	AUTO_INCREMENT,
  ITEM_NAME			VARCHAR(100)	NOT NULL,
  CATEGORY			VARCHAR(20)		NOT NULL,
  AUCTION_START		TIMESTAMP		NOT NULL 	DEFAULT NOW(),
  AUCTION_END		TIMESTAMP		NOT NULL,
  DESCRIPTION		TINYTEXT		NOT NULL,
  STATUS			VARCHAR(16)		NOT NULL	DEFAULT 'STARTING SOON',
  START_PRICE		DECIMAL(9,2)	NOT NULL,
  CURRENT_BID		DECIMAL(9,2)	NOT NULL,
  WINNER_ID			INTEGER,
  CREATOR_ID		INTEGER			NOT NULL,
  PHOTO				BLOB,

  PRIMARY KEY	(ITEM_ID),
  CONSTRAINT WINNER_ID_FK FOREIGN KEY (WINNER_ID) REFERENCES USERS (USER_ID) ON UPDATE CASCADE,
  CONSTRAINT ITEM_CREATOR_FK FOREIGN KEY	(CREATOR_ID) REFERENCES USERS (USER_ID) ON UPDATE CASCADE
)ENGINE=InnoDB;

ALTER TABLE ITEM ADD CONSTRAINT VALID_START_PRICE CHECK ( START_PRICE >= 0.00);

-- AUCTIONS
CREATE TABLE 		AUCTIONS (
  ITEM_ID		INTEGER			NOT NULL,
  USER_ID		INTEGER			NOT NULL,
  MAXIMUM_BID	DECIMAL(9,2)	NOT NULL,
  BID_TIME		TIMESTAMP		NOT NULL,

  PRIMARY KEY(ITEM_ID, USER_ID, MAXIMUM_BID),
  CONSTRAINT AUCTION_USER_FK FOREIGN KEY(USER_ID) REFERENCES USERS (USER_ID) ON UPDATE CASCADE,
  CONSTRAINT AUCTION_ITEM_FK FOREIGN KEY(ITEM_ID) REFERENCES ITEM (ITEM_ID) ON UPDATE CASCADE
)ENGINE=InnoDB;

ALTER TABLE AUCTIONS ADD CONSTRAINT VALID_MAX_BID CHECK ( MAXIMUM_BID > 0.00);
ALTER TABLE AUCTIONS ADD CONSTRAINT VALID_BID_TIME CHECK ( BID_TIME >= NOW());

-- BUYER FEEDBACK
CREATE TABLE		BUYER_FEEDBACK (
  ITEM_ID				INTEGER		NOT NULL,
  SATISFACTION			CHAR(1)		NOT NULL,
  PAYMENT_PROMPTNESS	CHAR(1)		NOT NULL,
  COMMENTS				TINYTEXT,

  PRIMARY KEY(ITEM_ID),
  CONSTRAINT BUYER_FEEDBACK_ITEM_FK FOREIGN KEY(ITEM_ID) 	REFERENCES ITEM (ITEM_ID) ON UPDATE CASCADE
)ENGINE=InnoDB;

ALTER TABLE BUYER_FEEDBACK ADD CONSTRAINT VALID_SATISFACTION CHECK ( SATISFACTION >= 1 AND SATISFACTION <= 9 );
ALTER TABLE BUYER_FEEDBACK ADD CONSTRAINT VALID_PAYMENT_PROMPTNESS CHECK ( PAYMENT_PROMPTNESS >= 1 AND PAYMENT_PROMPTNESS <= 9 );

-- SELLER FEEDBACK
CREATE TABLE		SELLER_FEEDBACK (
  ITEM_ID			INTEGER		NOT NULL,
  SATISFACTION		CHAR(1)		NOT NULL,
  ITEM_DELIVERY		CHAR(1)		NOT NULL,
  ITEM_QUALITY		CHAR(1)		NOT NULL,
  COMMENTS			TINYTEXT,

  PRIMARY KEY(ITEM_ID),
  CONSTRAINT SELLER_FEEDBACK_ITEM_FK FOREIGN KEY(ITEM_ID) 	REFERENCES ITEM (ITEM_ID) ON UPDATE CASCADE
)ENGINE=InnoDB;

ALTER TABLE SELLER_FEEDBACK ADD CONSTRAINT VALID_SATISFACTION CHECK ( SATISFACTION >= 1 AND SATISFACTION <= 9 );
ALTER TABLE SELLER_FEEDBACK ADD CONSTRAINT VALID_ITEM_DELIVERY CHECK ( ITEM_DELIVERY >= 1 AND ITEM_DELIVERY <= 9 );
ALTER TABLE SELLER_FEEDBACK ADD CONSTRAINT VALID_ITEM_QUALITY CHECK ( ITEM_QUALITY >= 1 AND ITEM_QUALITY <= 9 );