create table languages (
    id bigint primary key auto_increment,
    greetingPrefix varchar(100) not null,
    code varchar(3)
);