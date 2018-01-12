package com.book.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.Entity.book;
import com.book.Mapper.bookMapper;

@Service
public class bookService {

	@Autowired
	bookMapper bookMapper;
	
	public List<book> getAll(){
		return bookMapper.getAll();
	}
	
	public book getById(int id){
		return bookMapper.getBook(id);
	}
	
	public int updateBook(book book){
		return bookMapper.updateBook(book);
	}
	
	public List<book> search(String[] name,String[] author,String[] press,double nb,double nu){
		return bookMapper.search(name,author,press,nb,nu);
	}
}
