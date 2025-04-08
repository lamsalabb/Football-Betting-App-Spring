USE `football_directory`;

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(255) NOT NULL UNIQUE,
    `password` VARCHAR(255) NOT NULL,
    `bet_coins` INT DEFAULT 0,
    `active` INT DEFAULT 1,
    `favorite_team` VARCHAR(255)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `roles` (
    `user_id` VARCHAR(255) NOT NULL,
    `role` VARCHAR(50) NOT NULL,
    PRIMARY KEY (`user_id`)
 )ENGINE=InnoDB DEFAULT CHARSET=latin1;


INSERT INTO `users` (`username`, `password`, `bet_coins`, `active`, `favorite_team`)
VALUES
('john', '{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q', 500, 1, NULL),
('abiral', '{bcrypt}$2a$10$RL2tbEqiUk59Yy1nvZ.gmevWIjePZmQ.oAPKv5kVjOiEMs78anrnm', 9999, 1, NULL);

INSERT INTO `roles` (`user_id`, `role`)
VALUES
('abiral', 'ROLE_ADMIN'),
('john', 'ROLE_USER');
