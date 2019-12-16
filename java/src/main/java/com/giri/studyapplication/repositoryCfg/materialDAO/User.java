package com.giri.studyapplication.repositoryCfg.materialDAO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users",schema = "dbo")
public class User {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "uname")
	private String uname;
	@Column(name = "password")
	private String password;
	@Column(name = "authorities")
	private String authorities;
	@Column(name = "isAccountNonExpired")
	private char isAccountNonExpired;
	@Column(name = "isAccountNonLocked")
	private char isAccountNonLocked;
	@Column(name = "isCredentialsNonExpired")
	private char isCredentialsNonExpired;
	@Column(name = "isEnabled")
	private char isEnabled;

	public User(int id, String uname, String password, String authorities, char isAccountNonExpired,
			char isAccountNonLocked, char isCredentialsNonExpired, char isEnabled) {
		super();
		this.id = id;
		this.uname = uname;
		this.password = password;
		this.authorities = authorities;
		this.isAccountNonExpired = isAccountNonExpired;
		this.isAccountNonLocked = isAccountNonLocked;
		this.isCredentialsNonExpired = isCredentialsNonExpired;
		this.isEnabled = isEnabled;
	}

	public User() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAuthorities() {
		return authorities;
	}

	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}

	public char getIsAccountNonExpired() {
		return isAccountNonExpired;
	}

	public void setIsAccountNonExpired(char isAccountNonExpired) {
		this.isAccountNonExpired = isAccountNonExpired;
	}

	public char getIsAccountNonLocked() {
		return isAccountNonLocked;
	}

	public void setIsAccountNonLocked(char isAccountNonLocked) {
		this.isAccountNonLocked = isAccountNonLocked;
	}

	public char getIsCredentialsNonExpired() {
		return isCredentialsNonExpired;
	}

	public void setIsCredentialsNonExpired(char isCredentialsNonExpired) {
		this.isCredentialsNonExpired = isCredentialsNonExpired;
	}

	public char getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(char isEnabled) {
		this.isEnabled = isEnabled;
	}

}
