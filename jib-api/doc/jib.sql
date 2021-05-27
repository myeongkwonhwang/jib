create database jib encoding 'utf-8';

create user jibuser password 'jib!23';

alter database jib owner to jibuser;

grant all on database jib to jibuser with grant option;

create schema jib;

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
                          validation_img bytea NULL,
                          authority varchar(15) NOT NULL,
                          is_accepted boolean NOT NULL default false,
                          photo_provided boolean NOT NULL default false,
                          state varchar(20) NOT NULL,
                          CONSTRAINT pk_user PRIMARY KEY (user_no)
);

-- DROP TABLE jib.user_dst;
CREATE TABLE jib.user_dst (
                              user_no int8 NOT NULL,
                              dst_no int8 NOT NULL,
                              CONSTRAINT pk_userno_dstno PRIMARY KEY (user_no, dst_no),
                              CONSTRAINT fk_dstno FOREIGN KEY (user_no) REFERENCES destination(dst_no),
                              CONSTRAINT fk_userno FOREIGN KEY (user_no) REFERENCES "user"(user_no)
);

-- DROP SEQUENCE jib.user_preference_prf_no_seq;
CREATE SEQUENCE jib.user_preference_prf_no_seq
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 2147483647
    START 1
    CACHE 1
    NO CYCLE;

-- DROP TABLE jib.user_preference
CREATE TABLE jib.user_preference (
                          prf_no int8 NOT NULL default nextval('jib.user_preference_prf_no_seq'::regclass),
                          user_no int8 NOT null,
                          dstnt_prf varchar(500) null,
                          house_type varchar(500) null,
                          preference varchar(4000) null,
                          CONSTRAINT pk_user_preference PRIMARY KEY (prf_no),
                          CONSTRAINT fk_userno FOREIGN KEY (user_no) REFERENCES "user"(user_no)
);

