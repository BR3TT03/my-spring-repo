/**
 * @author Umesh Bhujel <yoomesbhujel@gmail.com>
 * Since Sep 24, 2019
 */
package com.ishanitech.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
}
