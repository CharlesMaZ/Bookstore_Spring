
create_table_sql
CREATE TABLE orders_order_items (order_id bigint NOT NULL, order_items_id bigint NOT NULL);
CREATE TABLE pg_stat_statements (userid oid, dbid oid, queryid bigint, query text, plans bigint, total_plan_time double precision, min_plan_time double precision, max_plan_time double precision, mean_plan_time double precision, stddev_plan_time double precision, calls bigint, total_exec_time double precision, min_exec_time double precision, max_exec_time double precision, mean_exec_time double precision, stddev_exec_time double precision, rows bigint, shared_blks_hit bigint, shared_blks_read bigint, shared_blks_dirtied bigint, shared_blks_written bigint, local_blks_hit bigint, local_blks_read bigint, local_blks_dirtied bigint, local_blks_written bigint, temp_blks_read bigint, temp_blks_written bigint, blk_read_time double precision, blk_write_time double precision, wal_records bigint, wal_fpi bigint, wal_bytes numeric);
CREATE TABLE order_item (id bigint NOT NULL, quantity integer NOT NULL, book_id bigint, orders bigint);
CREATE TABLE cart_item (id bigint NOT NULL, quantity integer NOT NULL, book_id bigint, cart_id bigint);
CREATE TABLE orders (id bigint NOT NULL, date timestamp without time zone, status smallint, user_id bigint);
CREATE TABLE users (id bigint NOT NULL, username character varying(255) NOT NULL, password character varying(255), cart_id bigint);
CREATE TABLE book (id bigint NOT NULL, author character varying(255), name character varying(255), price double precision, quantity integer NOT NULL);
CREATE TABLE roles (id bigint NOT NULL, name character varying(255));
CREATE TABLE user_roles (user_id bigint NOT NULL, role_id bigint NOT NULL);
CREATE TABLE cart (id bigint NOT NULL);





