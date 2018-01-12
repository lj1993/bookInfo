package com.book.Mapper;

import org.apache.ibatis.annotations.Mapper;
import com.book.Entity.user;

@Mapper
public interface userMapper {
	
	user findByUserName(String name);
	
	int addUser(user user);
	
	int addUserRoles(String username);
}
