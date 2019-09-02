package com.proj.sample.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Reviews {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int reviewerId;
	String reviewerName;
	String content;
	String rating;
	String publishedDate;

}
