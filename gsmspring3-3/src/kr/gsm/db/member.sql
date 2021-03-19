-- SQL 
create table member(
  num int not null primary key auto_increment, -- 번호
  id varchar(20) not null,
  pass varchar(20) not null,
  name varchar(30) not null,
  age int not null,
  phone varchar(30) not null,
  email varchar(50) not null,
  unique key(id)
);

insert into member(id,pass,name,age,phone,email) 
values('admin','admin','관리자',30,'010-1111-1111','admin@naver.com');

select * from member;