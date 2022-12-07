package com.kosa.app.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Setter
@Getter
public class MemberVo implements UserDetails{
	
	private String memberId;
	private String password;
	private String name;
	private String email;
	private Date birth;
	private String gender;
	private String provider;
	private String role;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
		auth.add(new SimpleGrantedAuthority(role));
		return auth;
	}
	@Override
	public String getUsername() {
		return memberId;
	}
	@Override
	public boolean isAccountNonExpired() { 
		return true; //계정 만료 여뷰
	}
	@Override
	public boolean isAccountNonLocked() {
		return true; //계정 잠김 여부
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true; //패스워드 만료 여부
	}
	@Override
	public boolean isEnabled() {
		return true; //계정 사용가능 여부
	}
}