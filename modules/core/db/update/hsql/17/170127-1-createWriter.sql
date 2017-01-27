create table TESTIMPORT_WRITER (
    ID integer not null,
    UUID varchar(36),
    --
    NAME varchar(255),
    FIRST_WRITTEN_BOOK_ID integer,
    SECOND_WRITEN_BOOK_ID integer,
    THIRD_WRITTEN_BOOK_ID integer,
    --
    primary key (ID)
);
