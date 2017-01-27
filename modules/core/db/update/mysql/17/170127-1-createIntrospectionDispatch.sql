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
);
