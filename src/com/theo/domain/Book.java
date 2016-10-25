package com.theo.domain;

import java.io.Serializable;

import org.springframework.stereotype.Component;


@Component
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private String author;
	private String publishHouse;
	private int price;
	private int nums;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishHouse() {
		return publishHouse;
	}
	public void setPublishHouse(String publishHouse) {
		this.publishHouse = publishHouse;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public Book() {
		super();
	}
	public Book(int id, String name, String author, String publishHouse,
			int price, int nums) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
		this.publishHouse = publishHouse;
		this.price = price;
		this.nums = nums;
	}
}
