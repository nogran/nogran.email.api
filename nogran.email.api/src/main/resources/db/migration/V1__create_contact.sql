CREATE TABLE contact (
  id bigint AUTO_INCREMENT PRIMARY KEY,
  name varchar(100) NOT NULL,
  phone varchar(14) NOT NULL,
  email varchar(255) NOT NULL,
  message varchar(255) NOT NULL,
  date timestamp NOT NULL
);