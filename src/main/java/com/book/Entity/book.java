package com.book.Entity;

public class book {

	private int ID;
	private String name;
	private String author;
	private String press;
	private double price;
	
	public int getID(){
		return this.ID;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getAuthor(){
		return this.author;
	}
	
	public String getPress(){
		return this.press;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public void setID(int id){
		this.ID=id;
	}
	
	public void setName(String name){
		this.name=name;
	}
	
	public void setAuthor(String author){
		this.author=author;
	}
	
	public void setPress(String press){
		this.press=press;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}
	
	public String toString(){
		return this.ID+this.name+this.author+this.press+this.price;
	}
}
