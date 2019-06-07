DROP TABLE IF EXISTS user;

CREATE TABLE user (
  id INT AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
);

INSERT INTO user (id, username, password) VALUES
  (10, 'Dangote', 'Dangote12'),
  (11, 'Gates', 'Gates123'),
  (12, 'Alakija', 'Alakija123'),
  (13, 'joyidahosa', 'joyida123');