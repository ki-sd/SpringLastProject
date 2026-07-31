package com.sist.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sist.mapper.BoardMapper;
import com.sist.vo.BoardVO;

import lombok.RequiredArgsConstructor;

import java.util.*;
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper mapper;
	@Override
	public List<BoardVO> boardListData(int start) {
		return mapper.boardListData(start);
	}

	@Override
	public int boardRowCount() {
		return mapper.boardRowCount();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		mapper.boardInsert(vo);
	}

	@Override
	public BoardVO boardUpdateDetail(int no) {
		BoardVO vo=mapper.boardUpdateDetail(no);
		return vo;
	}
	
	@Override
	public String boardUpdate(int no,BoardVO vo) {
		String dbpwd=mapper.boardGetPassword(no);
		String msg="NOPWD";
		if(dbpwd.equals(vo.getPwd())) {
			mapper.boardUpdate(vo);
			msg="OK";
		}
		return msg;
	}

	@Override
	public BoardVO boardDetailData(int no) {
		mapper.boardHitIncrement(no);
		return mapper.boardDetailData(no);
	}

	@Override
	@Transactional
	public void boardReplyInsert(int pno,BoardVO vo) {
		BoardVO pvo=mapper.boardParentInfoData(pno);
		mapper.boardIncrementStep(pvo.getGroup_id(), pvo.getGroup_step());
		vo.setGroup_id(pvo.getGroup_id());
		vo.setGroup_step(pvo.getGroup_step()+1);
		vo.setGroup_tab(pvo.getGroup_tab()+1);
		vo.setRoot(pno);
		vo.setDepth(0);
		mapper.boardReplyInsert(vo);
		mapper.boardDepthIncrement(pno);
	}

	@Override
	@Transactional
	public boolean boardDelete(int no, String pwd) {
		boolean bCheck=false;
		BoardVO vo=mapper.boardInfoData(no);
		String db_pwd=mapper.boardGetPassword(no);
		if(db_pwd.equals(pwd)) {
			bCheck=true;
			if(vo.getDepth()==0) {
				mapper.boardDelete(no);
			}else {
				String msg="관리자에 의해 삭제된 게시물입니다.";
				mapper.boardMsgUpdate(msg, no);
			}
			mapper.boardDepthDecrement(vo.getRoot());
		}
		return bCheck;
	}

}
