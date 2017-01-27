create table mode (
    ID bigint identity not null,
    --
    index_name varchar(128) not null,
    name varchar(128) not null,
    stateful_flag boolean not null,
    effective_dt timestamp,
    expiration_dt timestamp not null
);
