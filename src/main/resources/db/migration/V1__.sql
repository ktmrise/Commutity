create table USER
(
    NAME         VARCHAR(50),
    ID           INT auto_increment,
    ACCOUNT_ID   VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    BIO          VARCHAR(256),
    AVATAR_URL   VARCHAR(100),
    constraint USER_PK
        primary key (ID)
);