create table users
(
    id   bigint unsigned auto_increment,
    name varchar(100) not null,
    constraint id
        unique (id)
);

alter table users
    add primary key (id);

