create table todos (
    id bigint primary key auto_increment,
    text varchar(50) not null,
    isDone boolean
);