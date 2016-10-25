package com.theo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import com.theo.domain.Book;
import com.theo.service.MyCart;

public class MyCartImpl implements MyCart {
	private double allBookSums;

	public double getAllBookSums() {
		return allBookSums;
	}

	public void setAllBookSums(double allBookSums) {
		this.allBookSums = allBookSums;
	}

	HashMap<String, Book> hm = new HashMap<String, Book>();

	/**
	 * 添加书这个对�?
	 * 
	 * @param id
	 *            书的ID
	 * @param book
	 */
	public void addBook(String id, Book book) {
		if (hm.containsKey(id)) {
			hm.get(id).setNums(hm.get(id).getNums() + 1);
		} else {
			hm.put(id, book);
		}
	}

	/**
	 * 删除�?
	 * 
	 * @param id
	 */
	public void delBook(String id) {
		hm.remove(id);
	}

	/**
	 * 对购物车的更�?
	 * 
	 * @param id
	 * @param name
	 */
	public void updateBook(String id, String num) {
		hm.get(id).setNums(Integer.parseInt(num));
	}

	/**
	 * 获得购物车中的信�?
	 * 
	 * @param id
	 * @return
	 */
	public ArrayList<Book> getMyCatMess() {
		String id = null;
		ArrayList<Book> alBook = new ArrayList<Book>();
		Iterator<String> it = hm.keySet().iterator();
		while (it.hasNext()) {
			id = (String) it.next();
			Book book = (Book) hm.get(id);
			alBook.add(book);
		}
		return alBook;
	}

	public double getTotal() {
		double sum = 0;
		Iterator<String> it = hm.keySet().iterator();
		while (it.hasNext()) {
			String id = (String) it.next();
			Book book = (Book) hm.get(id);
			sum += book.getPrice() * book.getNums();
		}
		return sum;
	}

	/**
	 * 对购物车的清�?
	 */
	public void clearCar() {
		hm.clear();
	}
}
