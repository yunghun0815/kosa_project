package com.kosa.app.dao;

import org.apache.ibatis.annotations.Mapper;

import com.kosa.app.model.MemberVo;

@Mapper
public interface MemberDao {
	MemberVo login(String memberId);
	void signup(MemberVo vo);
	int memberCheck(String memberId);
	void oauthSignup(MemberVo vo);
}
