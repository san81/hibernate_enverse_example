drop table store
 create table store(store_number int(3) primary key auto_increment, store_name varchar(50), UNIQUE KEY `UK_s1wrksusdh1r9nhoau7qxggjn` (`store_name`));
 create table beam(beam_id int(5) primary key auto_increment, beam_tool_cat varchar(200), store_number int(3), 
 constraint  `store_store_number` foreign key(store_number) references store(store_number),
 unique key `beam_tool_cat` (`beam_tool_cat`));
 select * from store
 insert into store values (2,'abcdef')

drop table stock
 create table stock ( STOCK_ID int(5) auto_increment primary key, STOCK_CODE varchar(100), STOCK_NAME varchar(200))

 show processlist
show create table store
 kill 10
 select * from stock