package com.sist.service;

import java.util.List;


import com.sist.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardListData(int start);
	public int boardRowCount();
	public void boardInsert(BoardVO vo);
	public BoardVO boardDetailData(int no);
	public void boardReplyInsert(int no,BoardVO vo);
	public BoardVO boardUpdateDetail(int no);
	public String boardUpdate(int no,BoardVO vo);
}
