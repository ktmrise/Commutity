package com.ktm.mapper;

import com.ktm.model.User;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("insert into user (name,account_id,token,gmt_create,gmt_modified) values(#{name},#{accountId},#{token},#{gmtCreate},#{gmtModified})")
    public void insert(User user);
}
