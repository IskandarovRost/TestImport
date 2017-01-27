create table mode (
    ID bigint auto_increment,
    --
    index_name varchar(128) not null,
    name varchar(128) not null,
    stateful_flag boolean,
    effective_dt datetime(3),
    expiration_dt datetime(3),
    --
    primary key (ID)
);
