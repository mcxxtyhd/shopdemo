package com.theo.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.theo.dao.BookDao;
import com.theo.domain.Book;
import com.theo.domain.PageBean;
import com.theo.service.BookService;

@Service("bookService")
public class BookServiceImpl implements BookService{
	@Autowired
	private BookDao bookDao;

	/**
	 * 根据数据库获取所有书的内�?
	 * 
	 * @return book
	 */
	public ArrayList<Book> getAllBooks(PageBean pageBean) {
		return bookDao.getAllBooks(pageBean);
	}

	/**
	 * 根据书ID获取该书信息
	 * 
	 * @param id
	 * @return
	 */
	public Book getBookById(int id) {
		return bookDao.getBookById(id);
	}

	/* (non-Javadoc)
	 * @see com.theo.service.BookService#getAllPage()
	 * 获取�?有的页数
	 */
	public int getAllPage() {
		return bookDao.getAllPage();
	}
}
