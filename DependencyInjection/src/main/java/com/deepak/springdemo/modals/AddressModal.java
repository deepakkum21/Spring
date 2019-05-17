package com.deepak.springdemo.modals;

import org.springframework.stereotype.Service;

//@Component is a generic stereotype for any Spring-managed component or bean. 
//@Repository is a stereotype for the persistence layer.
//@Service is a stereotype for the service layer.
//@Controller is a stereotype for the presentation layer (spring-MVC).

@Service("address1")
public class AddressModal {
	
	private String city;
	private String state;
	private int pinCode;
	public AddressModal() {
		super();
		System.out.println("Addess Object created");
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPinCode() {
		return pinCode;
	}
	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}
	@Override
	public String toString() {
		return "AddressModal []";
	}

}
