package com.kosa.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kosa.app.dao.MemberDao;
import com.kosa.app.model.MemberVo;
import com.kosa.app.service.IMemberService;

@Service
public class MemberService implements IMemberService, UserDetailsService {
	
	@Autowired
	MemberDao memberDao;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		MemberVo vo =  memberDao.login(memberId);
		return vo;
	}
	
	@Override
	public void signup(MemberVo vo) {
		vo.setPassword(passwordEncoder.encode(vo.getPassword()));
		memberDao.signup(vo);
	}
}
