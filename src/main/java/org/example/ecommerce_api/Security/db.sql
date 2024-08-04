create table type_product
(
    type_id int auto_increment
        primary key,
    name    varchar(100) not null
);

create table products
(
    product_id  int auto_increment
        primary key,
    name        varchar(50)    not null,
    type_id     int            not null,
    price       decimal(10, 2) not null,
    rating      int            not null,
    image       varchar(255)   not null,
    description text           not null,
    quantity    int            not null,
    constraint products___fk___type
        foreign key (type_id) references type_product (type_id)
);

create table users
(
    user_id    int auto_increment
        primary key,
    username   varchar(50)                           not null,
    password   varchar(255)                          not null,
    email      varchar(100)                          not null,
    created_at timestamp default current_timestamp() null
);

create table sales
(
    sale_id     int auto_increment
        primary key,
    user_id     int                                   not null,
    total_price decimal(10, 2)                        null,
    sale_date   timestamp default current_timestamp() null,
    constraint sales_ibfk_1
        foreign key (user_id) references users (user_id)
);

create table sale_items
(
    item_id    int            not null,
    product_id int            not null,
    quantity   int            not null,
    price      decimal(10, 2) not null,
    primary key (item_id, product_id),
    constraint sale_items_ibfk_1
        foreign key (item_id) references sales (sale_id),
    constraint sale_items_ibfk_2
        foreign key (product_id) references products (product_id)
);

create index product_id
    on sale_items (product_id);

create index user_id
    on sales (user_id);

