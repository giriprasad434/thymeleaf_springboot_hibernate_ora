package com.giri.studyapplication.security.cfg;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.giri.studyapplication.repositoryCfg.materialDAO.User;

@SuppressWarnings("serial")
@Component
public class UserDetailimpl implements UserDetails {

	User user;

	public UserDetailimpl() {

	}

	public UserDetailimpl(User user) {
		super();
		this.user = user;
	}

	@Override
	public List<GrantedAuthority> getAuthorities() {

		List<GrantedAuthority> authorities = new ArrayList<>();
	
		String[] a =user.getAuthorities().split(",");
		for (String n : a) {
			authorities.add(new SimpleGrantedAuthority(n));
		}
		return authorities;
	}

	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUname();
	}

	@Override
	public boolean isAccountNonExpired() {
		return user.getIsAccountNonExpired()=='Y'?true:false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return user.getIsAccountNonLocked()=='Y'?true:false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return user.getIsCredentialsNonExpired()=='Y'?true:false;
	}

	@Override
	public boolean isEnabled() {
		return user.getIsEnabled()=='Y'?true:false;
	}

}
