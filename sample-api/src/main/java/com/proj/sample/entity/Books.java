package com.proj.sample.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Books")
@Data
public class Books {

	@Id
	String title;
	String author;
	String publishedDate;
	String isbn;
	@OneToMany(cascade = CascadeType.ALL)
	List<Reviews> reviews;

	public Books() {
	}

}
