/**
 * Author:  794473 - Amitoj Singh
 * Created: Jan 21, 2020
 */

DROP SCHEMA IF EXISTS `capstoneDB`;

CREATE SCHEMA IF NOT EXISTS `capstoneDB` DEFAULT CHARACTER SET latin1 ;
USE `capstoneDB` ;

/**
Creating table "roles"
*/

CREATE TABLE  IF NOT EXISTS `roles`
 (  `Role_ID` INT(1) NOT NULL ,
    `Role_Description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Role_ID`));

/**
Inserting Data values for the "roles table "
*/

INSERT INTO `roles` VALUES (1, 'Admin');
INSERT INTO `roles` VALUES (2, 'User');

/**
Creating table "provinces"
*/

CREATE TABLE IF NOT EXISTS `provinces`
 (  `Province_ID` INT(2) NOT NULL,
    `Province_Name` VARCHAR(50) NOT NULL,
    `Tax_Percentage` DOUBLE NOT NULL,
    PRIMARY KEY (`Province_ID`));

/**
Inserting Data values for the "provinces" table 
*/
INSERT INTO `provinces` VALUES (1, 'Alberta',5);
INSERT INTO `provinces` VALUES (2, 'British Columbia ',12);
INSERT INTO `provinces` VALUES (3, 'Manitoba',12);
INSERT INTO `provinces` VALUES (4, 'New-Brunswick',15);
INSERT INTO `provinces` VALUES (5, 'Newfoundland and Labrador',15);
INSERT INTO `provinces` VALUES (6, 'Northwest Territories',5);
INSERT INTO `provinces` VALUES (7, 'Nova Scotia',15);
INSERT INTO `provinces` VALUES (8, 'Nunavut',5);
INSERT INTO `provinces` VALUES (9, 'Ontario',13);
INSERT INTO `provinces` VALUES (10, 'Prince Edward Island',15);
INSERT INTO `provinces` VALUES (11, 'Québec',14.975);
INSERT INTO `provinces` VALUES (12, 'Saskatchewan',11);
INSERT INTO `provinces` VALUES (13, 'Yukon',5);

/**
Creating table "category"
*/

CREATE TABLE IF NOT EXISTS `category`
(   `Category_ID` INT(2) NOT NULL AUTO_INCREMENT,
    `Category_Description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Category_ID`));

/**
Inserting Data values for the "category" table 
*/

INSERT INTO `category` VALUES (1, 'Hats');
INSERT INTO `category` VALUES (2, 'Tops');
INSERT INTO `category` VALUES (3, 'Jeans');

/**
Creating table "user"
*/

CREATE TABLE IF NOT EXISTS `user`
(   `Email`     VARCHAR(100) NOT NULL UNIQUE,
    `First_Name` VARCHAR(50) NOT NULL,
    `Last_Name`  VARCHAR(50) NOT NULL,
    `Phone` VARCHAR(10) NOT NULL,
    `Address` VARCHAR(100) NOT NULL,
    `Postal_Code` VARCHAR(7) NOT NULL,
    `City` VARCHAR(50) NOT NULL,
    `Province` INT(2) NOT NULL,
    `Password` VARCHAR(200) NOT NULL,
    `Salt` VARCHAR(50) NOT NULL,
    `Password_Reset_UUID` VARCHAR(50),
    `Activation_UUID` VARCHAR(50),
    `Status` BOOLEAN NOT NULL DEFAULT TRUE,
    `Role` INT(1) NOT NULL,
    

     CONSTRAINT User_Email_PK PRIMARY KEY (Email),
     CONSTRAINT `user_Role_FK` FOREIGN KEY (`Role`) REFERENCES `roles` (`Role_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
     CONSTRAINT `user_Province_FK` FOREIGN KEY (`Province`) REFERENCES `provinces` (`Province_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT

    );

/**
Inserting Data values for the "user" table 
*/

INSERT INTO `user` (`Email`,`First_Name`,`Last_Name`,`Phone`,`Address`,`Postal_Code`,`City`,`Province`,`Password`,`Salt`,`Status`,`Role`)
VALUES ('admin@admin.com','Amitoj','Singh','5876642709','SAIT','T3J4N6','Calgary',1,'ac0798db97d6b1093af7d6e097018e21fc2db75245309065727f8297a214ab23','bPkLk6XySF/e07Tk3dYNymaQ//aJaK2yRr+ia8qxar8=',true,1);

INSERT INTO `user` (`Email`,`First_Name`,`Last_Name`,`Phone`,`Address`,`Postal_Code`,`City`,`Province`,`Password`,`Salt`,`Status`,`Role`)
VALUES ('user@user.com','Amitoj','Singh','5876642709','SAIT','T3J4N6','Calgary',5,'ac0798db97d6b1093af7d6e097018e21fc2db75245309065727f8297a214ab23','bPkLk6XySF/e07Tk3dYNymaQ//aJaK2yRr+ia8qxar8=',true,2);

INSERT INTO `user` (`Email`,`First_Name`,`Last_Name`,`Phone`,`Address`,`Postal_Code`,`City`,`Province`,`Password`,`Salt`,`Status`,`Role`)
VALUES ('user2@user.com','Rock','Oddy','5876642709','SAIT','T3J4N6','Calgary',5,'ac0798db97d6b1093af7d6e097018e21fc2db75245309065727f8297a214ab23','bPkLk6XySF/e07Tk3dYNymaQ//aJaK2yRr+ia8qxar8=',true,2);

/**
Creating table "items"
*/

CREATE TABLE IF NOT EXISTS `item`
( `Upsc` VARCHAR(15) NOT NULL,
  `Name` VARCHAR(50) NOT NULL,
  `Description` VARCHAR(100) ,
  `Cost` DOUBLE  NOT NULL,
  `Retail_Cost` DOUBLE  NOT NULL,
  `Category` INT(2) NOT NULL,
  `Image_Link` VARCHAR(100) NOT NULL,
  `Quantity` INT NOT NULL,
`Status` BOOLEAN NOT NULL DEFAULT TRUE,

   CONSTRAINT Item_Upsc_PK PRIMARY KEY (Upsc),
   CONSTRAINT `Item_Category_FK` FOREIGN KEY (`Category`) REFERENCES `category` (`Category_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
    );

/**
Inserting Data values for the "items" table 
*/

INSERT INTO `item` (`Upsc`,`Name`,`Description`,`Cost`,`Retail_Cost`,`Category`,`Image_Link`,`Quantity`,`Status`)
 VALUES ('12345678900','Kid Style hats','none',15.00,10.00,1,'products/1.jpg',100,true);

INSERT INTO `item` (`Upsc`,`Name`,`Description`,`Cost`,`Retail_Cost`,`Category`,`Image_Link`,`Quantity`,`Status`)
 VALUES ('12345678901','Stylish Shirt','none',30.00,12.10,2,'products/2.jpg',7,true);

INSERT INTO `item` (`Upsc`,`Name`,`Description`,`Cost`,`Retail_Cost`,`Category`,`Image_Link`,`Quantity`,`Status`)
 VALUES ('12345678902','Rugged Jeans','none',35.00,17.35,3,'products/3.jpg',23,true);

/** Order Status Details */

CREATE TABLE IF NOT EXISTS `Order_Status`
(   `Stat_ID` INT(2) NOT NULL ,
    `Stat_Description` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`Stat_ID`));

/**
Inserting Data values for the "Order stat" table 
*/

INSERT INTO `Order_Status` VALUES (1, 'CONFIRMED');
INSERT INTO `Order_Status` VALUES (2, 'CANCELLED');
INSERT INTO `Order_Status` VALUES (3, 'SHIPPED');

/***
Creating table "Orders"
*/

CREATE TABLE IF NOT EXISTS `orders`
(`Order_Number` VARCHAR(100) NOT NULL ,
 `Customer` VARCHAR(100) NOT NULL,
`Ship_fname` VARCHAR(100) NOT NULL,
`Ship_lname` VARCHAR(100) NOT NULL,
`Phone` VARCHAR(10) NOT NULL,
 `Order_Date` DATE NOT NULL,
 `Ship_Date` DATE ,
 `Ship_Address` VARCHAR(100) NOT NULL,
 `Ship_City` VARCHAR(50) NOT NULL,
 `Ship_Province` INT(2) NOT NULL,
 `Ship_Postal_Code` VARCHAR(6) NOT NULL,
 `Ship_Cost` DOUBLE NOT NULL,
 `Ship_Company` VARCHAR(50) ,
`Tracking_number` VARCHAR(50) ,
`Order_Total` DOUBLE NOT NULL,
`Order_stat` INT(2) NOT NULL,


CONSTRAINT Order_Number_PK PRIMARY KEY (Order_Number),
CONSTRAINT `Order_Customer_FK` FOREIGN KEY (`Customer`) REFERENCES `user` (`Email`) ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT `Order_Province_FK` FOREIGN KEY (`Ship_Province`) REFERENCES `provinces` (`Province_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT `Order_STAT_FK` FOREIGN KEY (`Order_stat`) REFERENCES `Order_Status` (`Stat_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
);

/**
Inserting Data values for the "orders" table 
*/

INSERT INTO orders VALUES ("2003060245340000077",'user@user.com','Lucky','Singh','5876642709','2020-01-23','2020-01-27','33 Marthas Meadow Drive NE','Calgary',1,'T3J4N6',5.00,'','',84,1);

/**
Creating table "Orders Items"
*/

CREATE TABLE IF NOT EXISTS `order_item`
(`Order_Item_Ref` VARCHAR(100) NOT NULL,
`Order_Number` VARCHAR(100) NOT NULL,
 `Item` VARCHAR(15) NOT NULL,
 `Cost` DOUBLE  NOT NULL,
 `Quantity` INT NOT NULL,
 `Order_total` DOUBLE NOT NULL,

CONSTRAINT OI_O_Number_PK PRIMARY KEY (Order_Item_Ref),
CONSTRAINT `OI_O_Number_FK` FOREIGN KEY (`Order_Number`) REFERENCES `orders` (`Order_Number`) ON DELETE RESTRICT ON UPDATE RESTRICT,
CONSTRAINT `OI_Item_FK` FOREIGN KEY (`Item`) REFERENCES `item` (`Upsc`) ON DELETE RESTRICT ON UPDATE RESTRICT
);

INSERT INTO `order_item` (`Order_Item_Ref`,`Order_Number`,`Item`,`Cost`,`Quantity`,`Order_total`)
 VALUES ("0","2003060245340000077",'12345678900',15.00,3,52.25);

INSERT INTO `order_item` (`Order_Item_Ref`,`Order_Number`,`Item`,`Cost`,`Quantity`,`Order_total`)
 VALUES ("1","2003060245340000077",'12345678901',30.00,1,31.5);


CREATE TABLE IF NOT EXISTS `contact`
(   `issueNumber` INT(4) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL ,
    `email` VARCHAR(100) NOT NULL ,
    `Issue` VARCHAR(150) NOT NULL,

  PRIMARY KEY (`issueNumber`));