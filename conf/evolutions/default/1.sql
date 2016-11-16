# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table projects (
  id                        bigint auto_increment not null,
  project_name              varchar(255),
  publisher                 varchar(255),
  provider                  varchar(255),
  status                    varchar(255),
  projectDescription        varchar(255),
  requiredExpertise         varchar(255),
  begintime                 varchar(255),
  endtime                   varchar(255),
  price                     varchar(255),
  constraint pk_projects primary key (id))
;

create table rates (
  id                        bigint auto_increment not null,
  user                      varchar(255),
  provider                  varchar(255),
  projectRate               varchar(255),
  providerRecommend         varchar(255),
  comments                  varchar(255),
  constraint pk_rates primary key (id))
;

create table service_publications (
  username                  varchar(255) not null,
  credential                varchar(255),
  researchAreas             varchar(255),
  publications              varchar(255),
  professionalServices      varchar(255),
  constraint pk_service_publications primary key (username))
;

create table user (
  name                      varchar(255) not null,
  password                  varchar(255),
  email                     varchar(255),
  secureQuestion            varchar(255),
  secureAnswer              varchar(255),
  constraint pk_user primary key (name))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table projects;

drop table rates;

drop table service_publications;

drop table user;

SET FOREIGN_KEY_CHECKS=1;

