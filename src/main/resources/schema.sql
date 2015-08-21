drop schema if exists users;
create schema if not exists users;
create sequence if not exists seq;


create table if not exists users.employee(
      employee_id int,
      employee_name varchar(45),
      CONSTRAINT pk_employee_id PRIMARY KEY (employee_id)

)