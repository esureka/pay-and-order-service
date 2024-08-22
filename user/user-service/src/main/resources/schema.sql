CREATE TABLE IF NOT EXISTS `users` (
    `id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(10) NOT NULL,
    `email` VARCHAR(30) NOT NULL,
    `user_role` VARCHAR(15) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `user_event`(
    `id` VARCHAR(30) NOT NULL,
    `user_id` INT NOT NULL,
    `published` VARCHAR(30) NOT NULL,
    `published_at` DATE,
    `created_at` DATE NOT NULL,
    PRIMARY KEY (`id`)
)