-- begin SWITCH_RULE
alter table switch_rule add constraint FK_SWITCH_RULE_BEGIN_MODE foreign key (BEGIN_MODE_ID) references mode(ID)^
alter table switch_rule add constraint FK_SWITCH_RULE_END_MODE foreign key (END_MODE_ID) references mode(ID)^
alter table switch_rule add constraint FK_SWITCH_RULE_BEFORE_DISPATCH foreign key (BEFORE_DISPATCH_ID) references introspection_dispatch(ID)^
alter table switch_rule add constraint FK_SWITCH_RULE_AFTER_DISPATCH foreign key (AFTER_DISPATCH_ID) references introspection_dispatch(ID)^
alter table switch_rule add constraint FK_SWITCH_RULE_CONDITION_DISPATCH foreign key (CONDITION_DISPATCH_ID) references introspection_dispatch(ID)^
create index IDX_SWITCH_RULE_END_MODE on switch_rule (END_MODE_ID)^
create index IDX_SWITCH_RULE_BEFORE_DISPATCH on switch_rule (BEFORE_DISPATCH_ID)^
create index IDX_SWITCH_RULE_CONDITION_DISPATCH on switch_rule (CONDITION_DISPATCH_ID)^
create index IDX_SWITCH_RULE_BEGIN_MODE on switch_rule (BEGIN_MODE_ID)^
create index IDX_SWITCH_RULE_AFTER_DISPATCH on switch_rule (AFTER_DISPATCH_ID)^
-- end SWITCH_RULE
-- begin TESTIMPORT_WRITER
alter table TESTIMPORT_WRITER add constraint FK_TESTIMPORT_WRITER_FIRST_WRITTEN_BOOK foreign key (FIRST_WRITTEN_BOOK_ID) references TESTIMPORT_BOOK(ID)^
alter table TESTIMPORT_WRITER add constraint FK_TESTIMPORT_WRITER_SECOND_WRITEN_BOOK foreign key (SECOND_WRITEN_BOOK_ID) references TESTIMPORT_BOOK(ID)^
alter table TESTIMPORT_WRITER add constraint FK_TESTIMPORT_WRITER_THIRD_WRITTEN_BOOK foreign key (THIRD_WRITTEN_BOOK_ID) references TESTIMPORT_BOOK(ID)^
create index IDX_TESTIMPORT_WRITER_FIRST_WRITTEN_BOOK on TESTIMPORT_WRITER (FIRST_WRITTEN_BOOK_ID)^
create index IDX_TESTIMPORT_WRITER_SECOND_WRITEN_BOOK on TESTIMPORT_WRITER (SECOND_WRITEN_BOOK_ID)^
create index IDX_TESTIMPORT_WRITER_THIRD_WRITTEN_BOOK on TESTIMPORT_WRITER (THIRD_WRITTEN_BOOK_ID)^
-- end TESTIMPORT_WRITER
