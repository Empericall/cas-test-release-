# --- !Ups
CREATE TABLE car_models
(
    "id"                bigserial primary key,
    "name"              varchar,
    "producing_started" date,
    "producing_end"     date
);

CREATE TABLE car_brands
(
    "id"      bigserial primary key,
    "name"    varchar NOT NULL,
    "country" varchar NOT NULL
);

CREATE TABLE cars_shop
(
    "id"             bigserial primary key,
    "car_brand"      integer NOT NULL references car_brands("id"),
    "car_model"      integer NOT NULL references car_models("id"),
    "producing_date" date    NOT NULL,
    "milesage"       integer NOT NULL,
    "price"          numeric NOT NULL
);

# --- !Downs
DROP TABLE IF EXISTS car_models;
DROP TABLE IF EXISTS car_brands;
DROP TABLE IF EXISTS cars_shop;