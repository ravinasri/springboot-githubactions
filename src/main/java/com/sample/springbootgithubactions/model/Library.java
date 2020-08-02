package com.sample.springbootgithubactions.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "accounts")
public class Library {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
private Long library_card_number;
private String password;
public Library() {
	super();
}
public Library( Long library_card_number, String password) {
	super();
	
	this.library_card_number = library_card_number;
	this.password = password;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public Long getLibrary_card_number() {
	return library_card_number;
}
public void setLibrary_card_number(Long library_card_number) {
	this.library_card_number = library_card_number;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "Library [id=" + id + ", library_card_number=" + library_card_number + ", password=" + password + "]";
}

}