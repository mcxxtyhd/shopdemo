package com.theo.service;

import java.util.ArrayList;
import com.theo.domain.Book;
import com.theo.domain.PageBean;

/**
 * @author theo 这是�?个业务�?�辑类，用于处理book相关的业务�?�辑
 */
public interface BookService {
	public ArrayList<Book> getAllBooks(PageBean pageBean);
	public Book getBookById(int id);
	public int getAllPage();
}
