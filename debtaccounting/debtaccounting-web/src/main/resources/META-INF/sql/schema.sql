drop schema if exists debtaccounting;
create schema debtaccounting;
grant all privileges on debtaccounting.* to 'debtaccounting'@'localhost' identified by 'debtaccounting';
grant all privileges on debtaccounting.* to 'debtaccounting'@'%' identified by 'debtaccounting';

