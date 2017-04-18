 CREATE TABLE post(
        ID  int primary key AUTO_INCREMENT,
        CONTENT varchar(140)
    );

create table users(
      username varchar_ignorecase(50) not null primary key,
      password varchar_ignorecase(250) not null, enabled boolean not null);

  create table authorities (
      username varchar_ignorecase(50) not null,
      authority varchar_ignorecase(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);

INSERT INTO users (username,password,enabled) VALUES ('cypmars','$2a$10$5ggU0eL2S7UtSABiJ78LP.gMWiY8c04fMvlRshXYN/jGjHXjP2Lcy',1);

INSERT INTO authorities(username,authority) VALUES('cypmars','USER');