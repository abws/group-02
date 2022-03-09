package com.spicesrus.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class BillingDetails {
@Id
@GeneratedValue
private int billingID;
@OneToOne
private Orders order;
private String firstName;
private String surname;
private String customerAddress;
private String customerPostcode;
private String customerEmail;
private String cardholderName;
private String cardNumber;
private String expiryDate;
private String cvvNumber;

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
public String getCardholderName() {
	return cardholderName;
}
public void setCardholderName(String cardholderName) {
	this.cardholderName = cardholderName;
}
public String getCardNumber() {
	return cardNumber;
}
public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}
public String getExpiryDate() {
	return expiryDate;
}
public void setExpiryDate(String expiryDate) {
	this.expiryDate = expiryDate;
}
public String getCvvNumber() {
	return cvvNumber;
}
public void setCvvNumber(String cvvNumber) {
	this.cvvNumber = cvvNumber;
}
public String getCustomerPostcode() {
	return customerPostcode;
}
public void setCustomerPostcode(String customerPostcode) {
	this.customerPostcode = customerPostcode;
}




}
