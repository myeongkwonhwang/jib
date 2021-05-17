-- DROP SEQUENCE jib.destination_dst_no_seq;

CREATE SEQUENCE jib.destination_dst_no_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;
-- DROP TABLE jib.destination;
CREATE TABLE jib.destination (
                                 dst_no int8 NOT NULL DEFAULT nextval('jib.destination_dst_no_seq'::regclass),
                                 name varchar(50) NOT NULL,
                                 country varchar(50) NULL,
                                 province varchar(50) NULL,
                                 city varchar(50) NULL,
                                 zip_code varchar(10) NOT NULL,
                                 latitude varchar(50) NOT NULL,
                                 longitude varchar(50) NOT NULL,
                                 created_at timestamp NULL,
                                 updated_at timestamp NULL,
                                 CONSTRAINT pk_destination PRIMARY KEY (dst_no)
);

-- DROP SEQUENCE jib.member_member_no_seq;
CREATE SEQUENCE jib.user_user_no_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
	CACHE 1
	NO CYCLE;

-- DROP TABLE jib.user;
CREATE TABLE jib.user (
                          user_no int8 NOT null default nextval('jib.user_user_no_seq'::regclass),
                          email varchar(100) NOT NULL,
                          first_name varchar(20) NOT NULL,
                          last_name varchar(20) NOT NULL,
                          birth_year varchar(4) NOT NULL,
                          lang_cd varchar(10) NULL,
                          "password" varchar(200) NULL,
                          phone_num varchar(15) NULL,
                          profile_img bytea NULL,
                          login_type varchar(10) NULL,
                          user_type varchar(10) NULL,
                          sns_type varchar(10) NULL,
                          sns_token varchar(100) NULL,
                          created_at timestamp NULL,
                          updated_at timestamp NULL,
                          validation_img bytea NOT NULL,
                          is_accepted boolean NOT NULL default false,
                          photo_provided boolean NOT NULL default false,
                          state int8 NOT NULL default 0,
                          CONSTRAINT pk_user PRIMARY KEY (user_no)
);



CREATE TABLE jib.auth (
                          auth_name varchar(10) NOT NULL,
                          CONSTRAINT pk_auth PRIMARY KEY (auth_name)

);

CREATE TABLE jib.user_auth (
     user_no int8 NOT null,
     auth_name varchar(10) NOT null,
     CONSTRAINT pk_user_auth PRIMARY KEY (user_no, auth_name),
     CONSTRAINT fk_user_no foreign key(user_no) references jib.user(user_no) on delete cascade,
     CONSTRAINT fk_auth_name foreign key (auth_name) references jib.auth(auth_name) on delete cascade
                           );



