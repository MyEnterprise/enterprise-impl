-- apply changes
create table address_entity (
  id                            uuid not null,
  desc                          varchar(255),
  main                          boolean default false not null,
  country                       varchar(255),
  state_or_province             varchar(255),
  city                          varchar(255),
  district_or_burgh             varchar(255),
  street                        varchar(255),
  number                        varchar(255),
  constraint pk_address_entity primary key (id)
);

create table aquisition_entity (
  id                            uuid not null,
  desc                          varchar(255),
  constraint pk_aquisition_entity primary key (id)
);

create table buyer_entity (
  id                            uuid not null,
  desc                          varchar(255),
  name                          varchar(255),
  type                          integer,
  constraint ck_buyer_entity_type check ( type in (0,1)),
  constraint pk_buyer_entity primary key (id)
);

create table coin_entity (
  id                            uuid not null,
  desc                          varchar(255),
  name                          varchar(255),
  constraint pk_coin_entity primary key (id)
);

create table contact_entity (
  id                            uuid not null,
  desc                          varchar(255),
  fax                           varchar(255),
  fone                          varchar(255),
  mail                          varchar(255),
  main                          boolean default false not null,
  website                       varchar(255),
  constraint pk_contact_entity primary key (id)
);

create table cost_entity (
  id                            uuid not null,
  desc                          varchar(255),
  amount                        decimal(16,3),
  constraint pk_cost_entity primary key (id)
);

create table division_entity (
  id                            uuid not null,
  desc                          varchar(255),
  constraint pk_division_entity primary key (id)
);

create table enterprise_entity (
  id                            uuid not null,
  desc                          varchar(255),
  name                          varchar(255),
  constraint pk_enterprise_entity primary key (id)
);

create table expedition_entity (
  id                            uuid not null,
  desc                          varchar(255),
  type                          integer,
  constraint ck_expedition_entity_type check ( type in (0,1)),
  constraint pk_expedition_entity primary key (id)
);

create table expedition_status_entity (
  id                            uuid not null,
  desc                          varchar(255),
  status                        integer,
  dt                            date,
  constraint ck_expedition_status_entity_status check ( status in (0,1,2)),
  constraint pk_expedition_status_entity primary key (id)
);

create table fee_entity (
  id                            uuid not null,
  desc                          varchar(255),
  amount                        decimal(16,3),
  constraint pk_fee_entity primary key (id)
);

create table fusion_entity (
  id                            uuid not null,
  desc                          varchar(255),
  constraint pk_fusion_entity primary key (id)
);

create table incorporation_entity (
  id                            uuid not null,
  desc                          varchar(255),
  constraint pk_incorporation_entity primary key (id)
);

create table lending_entity (
  id                            uuid not null,
  desc                          varchar(255),
  status                        integer,
  dt                            date,
  constraint ck_lending_entity_status check ( status in (0,1,2,3)),
  constraint pk_lending_entity primary key (id)
);

create table order_entity (
  id                            uuid not null,
  desc                          varchar(255),
  amount                        decimal(16,3),
  constraint pk_order_entity primary key (id)
);

create table product_entity (
  id                            uuid not null,
  desc                          varchar(255),
  name                          varchar(255),
  weight                        decimal(16,3),
  constraint pk_product_entity primary key (id)
);

create table resource_entity (
  id                            uuid not null,
  desc                          varchar(255),
  price_enum                    integer,
  constraint ck_resource_entity_price_enum check ( price_enum in (0,1,2,3)),
  constraint pk_resource_entity primary key (id)
);

create table seller_entity (
  id                            uuid not null,
  desc                          varchar(255),
  name                          varchar(255),
  type                          integer,
  constraint ck_seller_entity_type check ( type in (0,1)),
  constraint pk_seller_entity primary key (id)
);

create table service_entity (
  id                            uuid not null,
  desc                          varchar(255),
  name                          varchar(255),
  constraint pk_service_entity primary key (id)
);

create table tax_identification_entity (
  id                            uuid not null,
  desc                          varchar(255),
  identification                varchar(255),
  constraint pk_tax_identification_entity primary key (id)
);

create table transaction_status_entity (
  id                            uuid not null,
  desc                          varchar(255),
  status                        integer,
  dt                            date,
  constraint ck_transaction_status_entity_status check ( status in (0,1,2,3)),
  constraint pk_transaction_status_entity primary key (id)
);

create table transference_entity (
  id                            uuid not null,
  desc                          varchar(255),
  amount                        decimal(16,3),
  status                        integer,
  constraint ck_transference_entity_status check ( status in (0,1,2,3,4,5,6)),
  constraint pk_transference_entity primary key (id)
);

create table transference_status_entity (
  id                            uuid not null,
  desc                          varchar(255),
  status                        integer,
  dt                            date,
  constraint ck_transference_status_entity_status check ( status in (0,1,2,3)),
  constraint pk_transference_status_entity primary key (id)
);

create table transport_entity (
  id                            uuid not null,
  desc                          varchar(255),
  carrier                       varchar(255),
  type                          integer,
  constraint ck_transport_entity_type check ( type in (0,1,2,3,4,5)),
  constraint pk_transport_entity primary key (id)
);

create table wallet_entity (
  id                            uuid not null,
  desc                          varchar(255),
  type                          integer,
  has_encrypted                 boolean default false not null,
  algorithm_encrypted           varchar(255),
  region                        varchar(255),
  local                         varchar(255),
  constraint ck_wallet_entity_type check ( type in (0,1,2)),
  constraint pk_wallet_entity primary key (id)
);

