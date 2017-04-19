package com.practice.user.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

/*
create table user(
	id bigint primary key auto_increment,
	username varchar(255),
	password varchar(255),
   first_name varchar(255),
   last_name varchar(255),
	email varchar(255),
	address varchar(255),
	cellphone varchar(255),			
	gender varchar(20),	
	birthday date,
   code varchar(64),
   state int,
	created_on date	
); 
*/

@Entity
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String password;
	private int state; // user狀態，0表示尚未啟用，1表示啟用
	private String code; // 啟用碼
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String cellphone;
	private String gender;
	private Date birthday;
	@CreationTimestamp
	private Date createdOn;

	public User() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@CreationTimestamp
	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", state=" + state + ", code="
				+ code + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address="
				+ address + ", cellphone=" + cellphone + ", gender=" + gender + ", birthday=" + birthday
				+ ", createdOn=" + createdOn + "]";
	}
	
}
