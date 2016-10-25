package com.theo.service;

import java.util.ArrayList;

import com.theo.domain.Book;

/**
 * @author theo 操作我的购物�?
 */
public interface MyCart{
	
	public double getAllBookSums();
	public void setAllBookSums(double allBookSums);
	public void addBook(String id, Book book);
	public void delBook(String id);
	public void updateBook(String id, String num);
	public ArrayList<Book> getMyCatMess();
	public double getTotal();
	public void clearCar();
}
