package com.sist.service;

import com.sist.vo.MemberVO;

public interface MemberService {
	public void memberInsert(MemberVO vo);
	public MemberVO memberLogin(String userid,String pwd);
}
