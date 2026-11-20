-- liquibase formatted sql
-- changeset pjanik:create-books-table splitStatements:true endDelimiter:;
create table books (
                       is_deleted bit not null,
                       price decimal(38,2) not null,
                       id bigint not null auto_increment,
                       author varchar(255) not null,
                       cover_image varchar(255),
                       description varchar(255),
                       isbn varchar(255) not null,
                       title varchar(255) not null,
                       primary key (id)
)
-- rollback DROP TABLE books;