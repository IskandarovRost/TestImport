INSERT INTO mode (index_name,name, effective_dt) VALUES ('media', 'analyze', now());
INSERT INTO mode (index_name,name, effective_dt) VALUES ('media', 'sync', now());
INSERT INTO mode (index_name,name, effective_dt) VALUES ('media', 'report', now());

INSERT INTO introspection_dispatch (name, category, module_name, class_name, func_name) VALUES ('analyze.switch.after', 'switch', 'docserv', 'AnalyzeModeHandler', 'after_analyze');
INSERT INTO introspection_dispatch (name, category, module_name, class_name, func_name) VALUES ('report.switch.before', 'switch', 'docserv', 'DocumentServiceProcessHandler', 'before');
INSERT INTO introspection_dispatch (name, category, module_name, class_name, func_name) VALUES ('report.switch.after', 'switch', 'docserv', 'DocumentServiceProcessHandler', 'after');
