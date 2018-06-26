package com.ustcsoft.jt.vo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ustcsoft.framework.vo.UserVO;

@JsonIgnoreProperties(value = { "auth", "accountNonLocked", "enabled", "accountNonExpired", "credentialsNonExpired" })
public class User implements UserDetails {

	private UserVO userVo = new UserVO();
	
	public UserVO getUserVo() {
		return userVo;
	}

	public void setUserVo(UserVO userVo) {
		this.userVo = userVo;
	}

	private List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();

	@Override
	public String getPassword() {
		return userVo.getUserPwd();
	}

	public void addAuthority(GrantedAuthority authority) {
		this.auth.add(authority);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return auth;
	}

	@Override
	public String getUsername() {
		return userVo.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
