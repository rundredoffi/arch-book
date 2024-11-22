package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookJSon {
    @JsonProperty("title")
    private String title;

    @JsonProperty("author")
    private String author;

	public BookJSon() {
		super();
	
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
    
    // Constructeurs, getters et setters
}
