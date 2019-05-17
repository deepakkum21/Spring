package com.deepak.springdemo.modals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value="prototype")
public class StudentModal {
	
	private int sId;
	private String sName;
	
	@Autowired
	@Qualifier("address1")
	private AddressModal sAddress;
	
	public StudentModal() {
		super();
		System.out.println("Object created: ");
	}
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public AddressModal getsAddress() {
		return sAddress;
	}
	public void setsAddress(AddressModal sAddress) {
		this.sAddress = sAddress;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	@Override
	public String toString() {
		return "StudentModal [] to string printed";
	}
	
	

}
