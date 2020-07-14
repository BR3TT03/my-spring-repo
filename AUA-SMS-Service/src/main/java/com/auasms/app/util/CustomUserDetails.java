package com.auasms.app.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.auasms.app.models.User;


public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = 5253894137886934962L;
	Logger logger = LoggerFactory.getLogger(this.getClass());
	private User user;
	private List<GrantedAuthority> authority = new ArrayList<>();
	
	public CustomUserDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomUserDetails(User user, List<GrantedAuthority> authority) {
		super();
		this.user = user;
		this.authority = authority;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<GrantedAuthority> getAuthority() {
		return authority;
	}

	public void setAuthority(List<GrantedAuthority> authority) {
		this.authority = authority;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		authority.add(new SimpleGrantedAuthority(user.getRole()));
		return authority;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
}
