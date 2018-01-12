package com.book.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.book.Entity.sysRole;
import com.book.Entity.user;
import com.book.Mapper.userMapper;

@Service
public class customUserService implements UserDetailsService {

	@Autowired
	userMapper userMapper;
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		user user=userMapper.findByUserName(s);
		if(user==null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		List<SimpleGrantedAuthority> authorities=new ArrayList<>();
		for(sysRole role:user.getRoles()){
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
	}

}
