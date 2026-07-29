package com.sist.vo;

import lombok.Data;

@Data
public class FoodVO {
	private int no;
	private double score;
	private String name,address,phone,type,price,theme,time,reserve,parking,content,poster,images;
}
