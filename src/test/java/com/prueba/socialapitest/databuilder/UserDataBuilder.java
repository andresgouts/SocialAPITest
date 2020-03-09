package com.prueba.socialapitest.databuilder;

import com.prueba.socialapitest.domain.Address;
import com.prueba.socialapitest.domain.Company;
import com.prueba.socialapitest.domain.User;

public class UserDataBuilder {
	private long id;
	private String username;
	private String email;
	private Address address;
	private String phone;
	private String website;
	private Company company;
	
	public UserDataBuilder() {
		this.id = 1;
		this.username = "userName";
		this.email = "email";
		this.address = new Address();
		this.phone = "1111";
		this.website = "website.com";
		this.company = new Company();
	}
	
	public UserDataBuilder withId(long id) {
		this.id = id;
		return this;
	}
	
	public User build() {
		User user = new User();
		user.setAddress(address);
		user.setCompany(company);
		user.setEmail(email);
		user.setId(id);
		user.setPhone(phone);
		user.setUsername(username);
		user.setWebsite(website);
		return user;
	}	
	
}
