package com.theo.dao.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.theo.dao.BookDao;
import com.theo.domain.Book;
import com.theo.domain.PageBean;

@Repository
public class BookDaoImpl implements BookDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	/**
	 * 根据分页获取书的内容
	 * 
	 * @return book
	 */
	public ArrayList<Book> getAllBooks(PageBean pageBean) {
		String sql = "select * from book limit ?,?";
		RowMapper<Book> rowMapper  =new BeanPropertyRowMapper<>(Book.class);
		return (ArrayList<Book>) jdbcTemplate.query(sql, rowMapper, (pageBean.getPageNow() - 1)
				* pageBean.getPageSize(), pageBean.getPageSize());
	}

	/**
	 * 根据书ID获取该书信息
	 * 
	 * @param id
	 * @return
	 */
	public Book getBookById(int id) {
		String sql="select * from book where id=?";
		RowMapper<Book> rowMapper=new BeanPropertyRowMapper<>(Book.class);
		return jdbcTemplate.queryForObject(sql, rowMapper, id);
	}

	
	public int getAllPage() {
		String sql="select COUNT(*) from book ";
		return jdbcTemplate.update(sql);
	}
}
