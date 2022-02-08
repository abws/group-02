package com.example.spicesrus.security;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BillingDetails {
@Id
private int billingID;
//@OneToOne
private int ordernum;
private String firstName;
private String surname;
private String customerAddress;
private String customerEmail;

public int getBillingID() {
	return billingID;
}
public void setBillingID(int billingID) {
	this.billingID = billingID;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getCustomerAddress() {
	return customerAddress;
}
public void setCustomerAddress(String customerAddress) {
	this.customerAddress = customerAddress;
}
public String getCustomerEmail() {
	return customerEmail;
}
public void setCustomerEmail(String customerEmail) {
	this.customerEmail = customerEmail;
}
public int getOrdernum() {
	return ordernum;
}
public void setOrdernum(int ordernum) {
	this.ordernum = ordernum;
}



}
