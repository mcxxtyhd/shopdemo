package com.theo.dao;

import java.util.ArrayList;

import com.theo.domain.Book;
import com.theo.domain.PageBean;

public interface BookDao {
	public ArrayList<Book> getAllBooks(PageBean pageBean);
	public Book getBookById(int id);
	public int getAllPage();
}
