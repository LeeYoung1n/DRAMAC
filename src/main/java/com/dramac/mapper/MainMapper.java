package com.dramac.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.dramac.model.MainVO;

@Mapper
public interface MainMapper {
	
	public void join(MainVO mainVO);
	
	public MainVO login(MainVO mainVO);

}
