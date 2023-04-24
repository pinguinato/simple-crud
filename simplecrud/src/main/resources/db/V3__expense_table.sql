SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS;
SET FOREIGN_KEY_CHECKS=0;

USE simple_crud;

DROP TABLE IF EXISTS `expense`;

CREATE TABLE `simple_crud`.`expense` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) NOT NULL,
  `description` varchar(256) DEFAULT NULL,
  `amount` DOUBLE(10,2) DEFAULT NULL,
  `last_update_timestamp` DATETIME DEFAULT NULL,
  `expense_date` DATE DEFAULT NULL,
  `user_id` INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;