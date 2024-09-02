--Create user and set user permission to work with Table

create user to_do_list_user with password 'to_do_list';

alter user to_do_list_user set search_path to to_do_list_schema;

grant usage on schema to_do_list_schema to to_do_list_user;

grant select, insert, update, delete on all tables in schema to_do_list_schema to to_do_list_user;
grant usage, select on all sequences in schema to_do_list_schema to to_do_list_user;

alter default privileges in schema to_do_list_schema grant select, insert, update, delete on tables to to_do_list_user;
alter default privileges in schema to_do_list_schema grant select, usage on sequences to to_do_list_user;