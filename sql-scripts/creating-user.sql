-- Drop user first if they exist
DROP USER if exists 'footballuser'@'%' ;

-- Now create user with prop privileges
CREATE USER 'footballuser'@'%' IDENTIFIED BY 'footballuser';

GRANT ALL PRIVILEGES ON * . * TO 'footballuser'@'%';