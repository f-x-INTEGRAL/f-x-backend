CREATE TABLE orders (
    id bigint AUTO_INCREMENT,
    name varchar(10),
    quantity integer,
    phone_number varchar(20),
    bank_name varchar(10),
    status varchar(10),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    primary key (id)
);
