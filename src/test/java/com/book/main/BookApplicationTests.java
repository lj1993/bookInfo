package com.book.main;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.book.Entity.book;
import com.book.Entity.user;
import com.book.service.bookService;
import com.book.service.customUserService;
import com.mysql.fabric.xmlrpc.base.Array;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookApplicationTests {

	@Autowired
	bookService bookService;
	@Test
	public void contextLoads() {
		String[] name ={"bc","dark elf"};
		String[] author = null;
		String[] press = null;
		int nb = 0,nu = 1000;
		List<book> books=bookService.search(name,author,press,nb,nu);
		for(book book2:books){
			System.out.println(book2.toString());
		}
	}

}
