package com.sist.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.mapper.FoodMapper;
import com.sist.vo.FoodVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FoodServiceImpl implements FoodService {
	private final FoodMapper mapper;

	@Override
	public List<FoodVO> foodListData(int start, int end) {
		return mapper.foodListData(start, end);
	}

	@Override
	public int foodTotalPage() {
		return mapper.foodTotalPage();
	}

	@Override
	public FoodVO foodDetailData(int no) {
		return mapper.foodDetailData(no);
	}
}
