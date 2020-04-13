#Rise社区

## 资料
[spring 文档](https://spring.io/guides)

[spring web](https://spring.io/guides/gs/serving-web-content/)

[es](https://elasticsearch.cn/explore)

[Bootstrap](https://v3.bootcss.com/getting-started/)

[github OAuth](https://developer.github.com/apps/building-oauth-apps/creating-an-oauth-app/)





##   工具
.........  
git  
flyway  







## 脚本
```sql
create table USER
(
    NAME         VARCHAR(50),
    ID           INT auto_increment,
    ACCOUNT_ID   VARCHAR(50),
    TOKEN        CHAR(36),
    GMT_CREATE   BIGINT,
    GMT_MODIFIED BIGINT,
    constraint USER_PK
        primary key (ID)
);

-- auto-generated definition
create table QUESTION
(
    ID            BIGINT auto_increment,
    TITLE         VARCHAR(50),
    DESCRIPTION   TEXT,
    GMT_CREATE    BIGINT,
    GMT_MODIFIED  BIGINT,
    CREATOR       BIGINT,
    COMMENT_COUNT INT default 0,
    VIEW_COUNT    INT default 0,
    LIKE_COUNT    INT default 0,
    TAG           VARCHAR(256),
    constraint QUESTION_PK
        primary key (ID)
);

-- auto-generated definition
create table COMMENT
(
    ID           BIGINT auto_increment,
    PARENT_ID    BIGINT not null,
    TYPE         INT    not null,
    GMT_CREATE   BIGINT not null,
    COMMENTATOR  BIGINT,
    GMT_MODIFIED BIGINT not null,
    LIKE_COUNT   BIGINT,
    CONTENT      VARCHAR(256)
);

comment on column COMMENT.PARENT_ID is '父类id
';

comment on column COMMENT.TYPE is '父类类型';

comment on column COMMENT.GMT_CREATE is '创建时间
';

comment on column COMMENT.GMT_MODIFIED is '更新时间';

create unique index COMMENT_ID_UINDEX
    on COMMENT (ID);

alter table COMMENT
    add constraint COMMENT_PK
        primary key (ID);

```


```$xslt
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
```