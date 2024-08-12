CREATE TABLE IF NOT EXISTS `tbl_user` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(10) NOT NULL,
    `email` VARCHAR(30) NOT NULL,
    `password` VARCHAR(60) NOT NULL,
    `user_role` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`id`)
);