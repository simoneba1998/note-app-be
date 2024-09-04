SET search_path TO to_do_list_schema;

CREATE TABLE to_do_list (
    id                  BIGSERIAL       PRIMARY KEY,
    code                VARCHAR(50)     NOT NULL,
    description         VARCHAR(150)    NOT NULL,
    update_date         TIMESTAMP
);