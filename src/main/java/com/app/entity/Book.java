package com.app.entity;

import jakarta.persistence.*;

@Entity
@Table(name="book")
public class Book {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String title;
    private String author;
    private String category;

    public Book() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

   
}