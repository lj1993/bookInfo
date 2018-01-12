package com.book.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.mockito.internal.matchers.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.book.Entity.Msg;
import com.book.Entity.book;
import com.book.Entity.user;
import com.book.service.bookService;
import com.book.service.userService;

@Controller
public class HomeController {
	
	@Autowired
	private userService userService;
	@Autowired
	private bookService bookService;

	@RequestMapping("/")
	public String index(Model model){
		return home(model,new Msg());
	}
	
	@RequestMapping("/home")
	public String home(Model model,Msg msg){
		List<book> books=bookService.getAll();
		model.addAttribute("books",books);
		return "home";
	}
	
	@RequestMapping("/regin")
	public String regin(@RequestParam(value="user")String name,@RequestParam(value="pwd")String pwd,@RequestParam(value="email")String email){
		user user=new user();
		user.setName(name);
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		pwd=encoder.encode(pwd);
		user.setPwd(pwd);
		user.setEmail(email);
		userService.addUser(user);;
		return "login";
	}
	
	@RequestMapping("/registry")
	public String regist(){
		return "registry";
	}
	
	@RequestMapping("/toedit")
	public String edit(Model model,int id,Msg msg){
		book book=bookService.getById(id);
		model.addAttribute("book", book);
		if(msg!=null){
			model.addAttribute("msg",msg);
		}
		return "edit";
	}
	
	@RequestMapping("/edit")
	public String Update(book book){
		int re=bookService.updateBook(book);
		Model model = null;
		Msg msg=new Msg();
		if(re==1){
			msg.setMsg("success");
			return home(model,msg);
		}
		msg.setMsg("failure");
		return edit(model, book.getID(),msg);
	}
	
	@RequestMapping("/tosearch")
	public String search(Model model){		
		return "search";
	}
	
	@RequestMapping("/search")
	public String Find(@RequestParam(value="name",required=false)String[] name,@RequestParam(value="author",required=false)String[] author,
			@RequestParam(value="press",required=false)String[] press,@RequestParam(value="nb",required=false)String nb,@RequestParam(value="nu",required=false)String nu){
		for(String t:name){
			System.out.println(t);
		}
		double nbn=0,nun=0;
		if(nb!="")
			nbn=Double.parseDouble(nb);
		if(nu!="")
			nun=Double.parseDouble(nu);
		List<book> book=bookService.search(name, author, press, nbn, nun);
		return null;		
	}
	
	@RequestMapping("/unv")
	@ResponseBody
	public String userNameValidation(@RequestParam(value="name") String name){
		System.out.println(name);
		return userService.findByName(name);
	}
}
