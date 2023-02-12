SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS;
SET FOREIGN_KEY_CHECKS=0;

USE simple_crud;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `simple_crud`.`user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NULL,
  `email` varchar(256) NULL,
  PRIMARY KEY (`id`)
);

SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;