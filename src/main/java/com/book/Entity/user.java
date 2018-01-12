package com.book.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class user implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String pwd;
	private String email;
	private List<sysRole> sysRoles;
	
/*	public String getName(){
		return this.name;
	}
	
	public String getPwd(){
		return this.pwd;
	}*/
	
	public void setId(int id){
		this.id=id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public List<sysRole> getRoles(){
		return this.sysRoles;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setRoles(List<sysRole> sysRoles){
		this.sysRoles=sysRoles;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setPwd(String pwd) {
		this.pwd=pwd;
	}
	
	public void setEmail(String email) {
		this.email=email;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		List<GrantedAuthority> authorities=new ArrayList<>();
		List<sysRole> sysRoles=this.sysRoles;
		for(sysRole role:sysRoles){
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.pwd;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
