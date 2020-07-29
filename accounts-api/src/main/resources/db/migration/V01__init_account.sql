
CREATE TABLE account
(
  id bigint auto_increment NOT NULL,
  this_name character varying(100) NOT NULL,
  main_value decimal(20,2) NOT NULL,
  due_date date NOT NULL,
  payment_date date,

  PRIMARY KEY (id)
);
