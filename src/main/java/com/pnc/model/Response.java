package com.pnc.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;

public class Response extends Book {

	private String id;
	private List<String> book;
	private int count;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public List<String> getBook() {
		return book;
	}
	public void setBook(List<String> book) {
		this.book = book;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		
		return "Response [id=" + id + ", book=" + book + ", count=" + count + ", getId()=" + getId() + ", getBook()="
				+ getBook() + ", getCount()=" + getCount() + ", getAuthor()=" + getAuthor() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
}
