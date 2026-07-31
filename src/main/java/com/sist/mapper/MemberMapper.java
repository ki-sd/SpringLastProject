package com.sist.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.sist.vo.MemberVO;

@Mapper
public interface MemberMapper {
	@Insert("INSERT INTO springMember(userid,userpwd,username,sex) "
			+ "VALUES(#{userid},#{userpwd},#{username},#{sex})")
	public void memberInsert(MemberVO vo);
	
	@Select("SELECT userpwd "
			+ "FROM springMember "
			+ "WHERE userid=#{userid}")
	public String memberGetPassword(String userid);
	
	@Select("SELECT COUNT(*) "
			+ "FROM springMember "
			+ "WHERE userid=#{userid}")
	public int memberGetCount(String userid);
	
	@Select("SELECT userid,username,sex,enable "
			+ "FROM springMember "
			+ "WHERE userid=#{userid}")
	public MemberVO memberLoginData(String userid);
}