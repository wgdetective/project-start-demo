CREATE USER 'testuser'@'%' IDENTIFIED BY 'testpass';
CREATE DATABASE project_start_demo DEFAULT CHARACTER SET utf8 DEFAULT COLLATE utf8_bin;
GRANT ALL PRIVILEGES ON project_start_demo.* TO 'testuser'@'%' IDENTIFIED BY 'testpass';
GRANT GRANT OPTION ON project_start_demo.* TO 'testuser'@'%' IDENTIFIED BY 'testpass';
FLUSH PRIVILEGES;
