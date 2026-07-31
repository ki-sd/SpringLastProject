package com.sist.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.*;
import com.sist.vo.BoardVO;
@Mapper
public interface BoardMapper {
	@Select("SELECT no,name,subject,TO_CHAR(regdate,'yyyy-mm-dd') AS dbday,hit,group_tab "
			+ "FROM springReplyBoard "
			+ "ORDER BY group_id DESC, group_step ASC "
			+ "OFFSET #{start} ROWS FETCH NEXT 10 ROWS ONLY")
	public List<BoardVO> boardListData(int start);
	
	@Select("SELECT COUNT(*) FROM springReplyBoard")
	public int boardRowCount();
	
	@Insert("INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id) "
			+ "VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},(SELECT NVL(MAX(group_id)+1,1) FROM springReplyBoard))")
	public void boardInsert(BoardVO vo);
	
	// 상세보기
	@Update("UPDATE springReplyBoard "
			+ "SET hit=hit+1 "
			+ "WHERE no=#{no}")
	public void boardHitIncrement(int no);
	
	@Select("SELECT no,name,subject,content,TO_CHAR(regdate,'yyyy-mm-dd') AS dbday, hit "
			+ "FROM springReplyBoard "
			+ "WHERE no=#{no}")
	public BoardVO boardDetailData(int no);
	
	// 답변하기   ===> Transaction
	// 1. 상위 데이터 읽기
	@Select("SELECT group_id,group_step,group_tab "
			+ "FROM springReplyBoard "
			+ "WHERE no=#{no}")
	public BoardVO boardParentInfoData(int no);
	
	// 2. UPDATE
	@Update("UPDATE springReplyBoard "
			+ "SET group_step=group_step+1 "
			+ "WHERE group_id=#{group_id} "
			+ "AND group_step>#{group_step}")
	public void boardIncrementStep(@Param("group_id")int group_id,@Param("group_step")int group_step);
	
	// 3. INSERT
	@Insert("INSERT INTO springReplyBoard(no,name,subject,content,pwd,group_id,group_step,group_tab,root,depth) "
			+ "VALUES(srb_no_seq.nextval,#{name},#{subject},#{content},#{pwd},#{group_id},#{group_step},#{group_tab},#{root},#{depth})")
	public void boardReplyInsert(BoardVO vo);
	
	// 4. UPDATE
	@Update("UPDATE springReplyBoard "
			+ "SET depth=depth+1 "
			+ "WHERE no=#{no}")
	public void boardDepthIncrement(int no);
	
	// 수정     ===> Transaction
	@Select("SELECT no,name,subject,content "
			+ "FROM springReplyBoard "
			+ "WHERE no=#{no}")
	public BoardVO boardUpdateDetail(int no);
	
	@Select("SELECT pwd "
			+ "FROM springReplyBoard "
			+ "WHERE no=#{no}")
	public String boardGetPassword(int no);
	
	@Update("UPDATE springReplyBoard "
			+ "SET name=#{name},subject=#{subject},content=#{content} "
			+ "WHERE no=#{no}")
	public void boardUpdate(BoardVO vo);
	
	// 삭제     ===> Transaction
	@Select("SELECT root,depth FROM springReplyBoard "
			+ "WHERE no=#{no}")
	public BoardVO boardInfoData(int no);
	
	// 3-1. 결과 ==> 답변이 있는 경우
	@Update("UPDATE springReplyBoard "
			+ "SET subject=#{msg},content=#{msg} "
			+ "WHERE no=#{no}")
	public void boardMsgUpdate(@Param("msg")String msg,@Param("no")int no);
	
	// 3-2. 결과 ==> 답변이 없는 경우
	@Delete("DELETE FROM springReplyBoard "
			+ "WHERE no=#{no}")
	public void boardDelete(int no);
	
	// 4. 상위 게시물 Depth감소
	@Update("UPDATE springReplyBoard "
			+ "SET depth=depth-1 "
			+ "WHERE no=#{no}")
	public boolean boardDepthDecrement(int no);
}
