-- begin INTROSPECTION_DISPATCH
create table introspection_dispatch (
    ID bigint auto_increment,
    --
    name varchar(128),
    category varchar(128),
    package_name varchar(128),
    module_name varchar(128) not null,
    class_name varchar(128),
    func_name varchar(128),
    --
    primary key (ID)
)^
-- end INTROSPECTION_DISPATCH
-- begin MODE
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
)^
-- end MODE
-- begin SWITCH_RULE
create table switch_rule (
    ID bigint auto_increment,
    --
    index_name varchar(128) not null,
    name varchar(128) not null,
    begin_mode_id bigint not null,
    end_mode_id bigint not null,
    before_dispatch_id bigint not null,
    after_dispatch_id bigint not null,
    condition_dispatch_id bigint,
    --
    primary key (ID)
)^
-- end SWITCH_RULE
-- begin TESTIMPORT_WRITER
create table TESTIMPORT_WRITER (
    ID integer,
    UUID varchar(32),
    --
    NAME varchar(255),
    FIRST_WRITTEN_BOOK_ID integer,
    SECOND_WRITEN_BOOK_ID integer,
    THIRD_WRITTEN_BOOK_ID integer,
    --
    primary key (ID)
)^
-- end TESTIMPORT_WRITER
-- begin TESTIMPORT_BOOK
create table TESTIMPORT_BOOK (
    ID integer,
    UUID varchar(32),
    --
    NAME_OF_BOOK varchar(255),
    --
    primary key (ID)
)^
-- end TESTIMPORT_BOOK
