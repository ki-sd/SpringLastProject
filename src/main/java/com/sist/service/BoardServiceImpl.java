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
		BoardVO dbvo=mapper.boardGetPassword(no);
		String msg="NOPWD";
		if(dbvo.getPwd().equals(vo.getPwd())) {
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

}
