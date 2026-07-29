package com.sist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.mapper.GoodsMapper;
import com.sist.vo.GoodsVO;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class GoodsServiceImpl implements GoodsService {
	private final GoodsMapper mapper;
	@Override
	public List<GoodsVO> goodsListData(int start) {
		return mapper.goodsListData(start);
	}

	@Override
	public int goodsTotalPage() {
		return mapper.goodsTotalPage();
	}

	@Override
	public GoodsVO goodsDetailData(int no) {
		return mapper.goodsDetailData(no);
	}

}
