package com.bookstore.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration {

	private String name;
	private String userName;
	private String password;
	private Long phoneNumber;
	private int pincode;
	private String locality;
	private String address;
	private String city_town;
	private String landMark;
	private String type;


}
