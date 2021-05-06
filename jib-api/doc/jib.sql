
-- DROP TABLE jib.destination;
CREATE TABLE jib.destination (
                                 dstNo int8 NOT NULL,
                                 name varchar(50) NOT NULL,
                                 country varchar(50) NULL,
                                 province varchar(50) NULL,
                                 city varchar(50) NULL,
                                 zipCode varchar(10) NOT NULL,
                                 latitude varchar(50) NOT NULL,
                                 longitude varchar(50) NOT NULL,
                                 createdAt timestamp NULL,
                                 updatedAt timestamp NULL,
                                 CONSTRAINT pk_destination PRIMARY KEY (dstNo)
);

-- DROP TABLE jib.user;
CREATE TABLE jib.user (
                            userNo int8 NOT NULL,
                            dstNo int8 NOT NULL,
                            email varchar(100) NOT NULL,
                            firtName varchar(20) NOT NULL,
                            lastName varchar(20) NOT NULL,
                            birthYear varchar(4) NOT NULL,
                            langCd varchar(10) NULL,
                            password varchar(200) NULL,
                            phoneNum varchar(15) NULL,
                            profileImg bytea NULL,
                            usertype varchar(10) NULL,
                            snsnType varchar(10) NULL,
                            snsToken varchar(100) NULL,
                            createdAt timestamp NULL,
                            updatedAt timestamp NULL,
                            CONSTRAINT pk_user PRIMARY KEY (userNo, dstNo)
);

ALTER TABLE jib.user ADD CONSTRAINT FK_destination_TO_user_1 FOREIGN KEY (dstNo) REFERENCES jib.destination (dstNo);
