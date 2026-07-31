package com.sist.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sist.mapper.MemberMapper;
import com.sist.vo.MemberVO;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final BCryptPasswordEncoder encoder;
	private final MemberMapper mapper;
	@Override
	public void memberInsert(MemberVO vo) {
		mapper.memberInsert(vo);
	}
	@Override
	public MemberVO memberLogin(String userid, String pwd) {
		String msg="NOID";
		MemberVO vo=new MemberVO();
		int count=mapper.memberGetCount(userid);
		if(count>0) {
			String dbpwd=mapper.memberGetPassword(userid);
			boolean bCheck=encoder.matches(pwd, dbpwd);
			if(bCheck) {
				msg="OK";
				vo=mapper.memberLoginData(userid);
			}else {
				msg="NOPWD";
			}
		}
		vo.setMsg(msg);
		return vo;
	}

}
