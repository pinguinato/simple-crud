SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS;
SET FOREIGN_KEY_CHECKS=0;

USE simple_crud;

DROP TABLE IF EXISTS `inventory`;
DROP TABLE IF EXISTS `item`;


CREATE TABLE `simple_crud`.`item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(256) UNIQUE NOT NULL,
  `description` varchar(512) NOT NULL,
  `added_on` datetime NOT NULL,
  PRIMARY KEY (`item_id`)
);

CREATE TABLE `simple_crud`.`inventory` (
  `item_id` int(11) NOT NULL,
  `count` int(11) NULL,
  `updated_on` DATETIME NOT NULL,
  PRIMARY KEY (`item_id`),
  CONSTRAINT `fk_inventory_1`
  FOREIGN KEY (`item_id`)
  REFERENCES `simple_crud`.`item` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

