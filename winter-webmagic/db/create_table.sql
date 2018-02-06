
CREATE DATABASE IF NOT EXISTS winterdb DEFAULT CHARSET utf8 COLLATE utf8_general_ci;
GRANT ALL PRIVILEGES ON winterdb.* TO 'winter'@'localhost' identified by 'winter123' WITH GRANT OPTION ;
flush privileges;



