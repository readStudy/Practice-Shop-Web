package com.practice.user.form;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import com.practice.user.model.User;

public class UserForm {
	@NotEmpty
	private String username;
	@NotEmpty
	private String password;
	@NotEmpty
	private String repassword;
	@NotEmpty
	private String firstName;
	@NotEmpty
	private String lastName;
	@NotEmpty
	private String email;
	@NotEmpty
	private String address;
	@NotEmpty
	private String cellphone;
	@NotEmpty
	private String gender;
	@NotNull
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String code;
	private int state;

	public UserForm() {

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

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
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
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public User toUser() {

		User user = new User();
		user.setAddress(address);
		user.setBirthday(birthday);
		user.setCellphone(cellphone);
		user.setCode(code);
		user.setEmail(email);
		user.setFirstName(firstName);
		user.setGender(gender);
		user.setLastName(lastName);
		user.setPassword(password);
		user.setState(state);
		user.setUsername(username);

		return user;
	}

	@Override
	public String toString() {
		return "UserRegisterForm [username=" + username + ", password=" + password + ", repassword=" + repassword
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", address=" + address
				+ ", cellphone=" + cellphone + ", gender=" + gender + ", birthday=" + birthday + "]";
	}
}
