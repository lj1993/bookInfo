package com.book.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.book.Entity.book;

@Mapper
public interface bookMapper {

	List<book> getAll();
	
	book getBook(int id);
	
	int updateBook(book book);
	
	List<book> search(@Param("name")String[] name, @Param("author")String[] author,
			@Param("press")String[] press, @Param("nd")double nb, @Param("nu")double nu);
}
