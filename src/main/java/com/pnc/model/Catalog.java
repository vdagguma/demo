package com.pnc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties({"title","genre","price","description"})
public class Catalog {
	private String id;
	private String author;
	private String title;
	private String genre;
	private float price;
	private String description;
	
	@JsonProperty("Book_id")
	public String getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Catalog [id=" + id + ", author=" + author + ", title=" + title + ", genre=" + genre + ", price=" + price
				+ ", description=" + description + ", toString()=" + super.toString() + "]";
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	} 
}
