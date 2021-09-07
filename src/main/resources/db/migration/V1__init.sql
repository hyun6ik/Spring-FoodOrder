create table food
(
    id        bigint auto_increment
        primary key,
    food_name varchar(255) null
);

create table menu
(
    id        bigint auto_increment
        primary key,
    food_name varchar(255) null,
    shop_id   bigint       null
);

create table orders
(
    id               bigint auto_increment
        primary key,
    address          varchar(255) null,
    delivered_finish bit          not null,
    estimated_time   int          null,
    order_date       datetime(6)  null,
    shop_id          bigint       null
);

create table order_food
(
    id        bigint auto_increment
        primary key,
    food_name varchar(255) null,
    orders_id bigint       null,
    constraint FK6kqqwt81q6j5sngsroljb89wd
        foreign key (orders_id) references orders (id)
);

create table shop
(
    id           bigint auto_increment
        primary key,
    shop_address varchar(40) null,
    shop_name    varchar(20) null
);

