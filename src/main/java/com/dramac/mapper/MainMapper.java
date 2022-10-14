package com.dramac.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.dramac.model.MainVO;

@Mapper
public interface MainMapper {
	
	public MainVO login(MainVO mainVO);

}
