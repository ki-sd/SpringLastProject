package com.sist.vo;

import lombok.Data;

@Data
public class FoodVO {
	private int no,hit;
	private double score;
	private String name,address,phone,type,price,theme,time,reserve,parking,content,poster,images;
}
