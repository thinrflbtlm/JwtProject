/******************************************************************************
 * Copyright (c) 2017-2018. Spring-Boot -Version 2.1.0.RELEASE                *
 * UserMapper.java  181209 03:06:31 by @Chenccsy                            *
 * JavaProject builded by IDE@ ,all rights reserved.                          *
 ******************************************************************************/

package cc.test.invt2.mapper;

import cc.test.invt2.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

     User findByName(@Param("username") String username);

     User findByLogin(@Param("username") String username,
                      @Param("userpwd") String userpwd);

     @Update("update user set loginTime = now() where username = #{username}")
     int updatelogintime(@Param("username")String username);
}
