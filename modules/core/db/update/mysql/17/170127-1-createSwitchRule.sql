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
);
