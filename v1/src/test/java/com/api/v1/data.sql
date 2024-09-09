CREATE TABLE customer (
  id VARCHAR(255) PRIMARY KEY, -- UUID represented as string
  first_name VARCHAR(255) NOT NULL,
  middle_name VARCHAR(255),
  last_name VARCHAR(255) NOT NULL,
  ssn VARCHAR(9) NOT NULL UNIQUE,
  birth_date DATE NOT NULL,
  email VARCHAR(255) NOT NULL,
  address VARCHAR(255) NOT NULL,
  phone_number VARCHAR(10) NOT NULL,
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  update_at DATETIME
);