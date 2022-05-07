package com.student.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.student.entities.Login;


public class UserDetailsImpl implements UserDetails {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String username;
	@JsonIgnore
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;

	

	public UserDetailsImpl(Integer id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	}


	public static UserDetailsImpl build(Login login) {

		return new UserDetailsImpl(
				login.getId(), 
				login.getUsername(), 
				login.getPassword()
				);
	}
	
	
	
	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}


	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
