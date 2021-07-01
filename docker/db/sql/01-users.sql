create table users
(
    id       bigint unsigned auto_increment,
    name     varchar(100) not null,
    login_id varchar(100) not null,
    gender   int          not null,
    email    varchar(100) not null,
    password varchar(100) not null,
    constraint id
        unique (id),
    constraint users_email_uindex
        unique (email)
);

alter table users
    add primary key (id);

