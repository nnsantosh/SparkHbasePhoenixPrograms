CREATE TABLE IF NOT EXISTS employee (
      id BIGINT NOT NULL,
      firstName VARCHAR,
      lastName VARCHAR,
      state CHAR(2),
      city VARCHAR,
      zipCode VARCHAR,
      country VARCHAR,
      created_date DATE,
      last_updated DATE,
      CONSTRAINT emp_pk PRIMARY KEY (id));
