package com.bookstore.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="OrderInfo")
public class OrderInfo {
	
@Id
@Column(name="orderId")
@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_seq")
@SequenceGenerator(sequenceName = "order_sequence", allocationSize = 10, name = "order_seq")
private int orderId;

@Column(name="quantity")
private int quantity;


@Column(name="subTotal")
private float subTotal;


@Column(name="total")
private float total;


@Column(name="orderStatus")
private String orderStatus;

@NotEmpty(message = "PaymentMethod is mandatory")
@Column(name="paymentMethod")
@Length(min=2, max=16)
private String paymentMethod;

@OneToMany(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
@JoinColumn(name = "orderId", referencedColumnName = "orderId")
private List<BookDetails> book;

@OneToOne
private Customer customer;

public OrderInfo() {
	
}

public OrderInfo(int orderId, int quantity, float subTotal, float total, String orderStatus,
		@NotEmpty(message = "PaymentMethod is mandatory") @Length(min = 2, max = 16) String paymentMethod,
		List<BookDetails> book, Customer customer) {
	
	this.orderId = orderId;
	this.quantity = quantity;
	this.subTotal = subTotal;
	this.total = total;
	this.orderStatus = orderStatus;
	this.paymentMethod = paymentMethod;
	this.book = book;
	this.customer = customer;
}

public int getOrderId() {
	return orderId;
}

public void setOrderId(int orderId) {
	this.orderId = orderId;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

public float getSubTotal() {
	return subTotal;
}

public void setSubTotal(float subTotal) {
	this.subTotal = subTotal;
}

public float getTotal() {
	return total;
}

public void setTotal(float total) {
	this.total = total;
}

public String getOrderStatus() {
	return orderStatus;
}

public void setOrderStatus(String orderStatus) {
	this.orderStatus = orderStatus;
}

public String getPaymentMethod() {
	return paymentMethod;
}

public void setPaymentMethod(String paymentMethod) {
	this.paymentMethod = paymentMethod;
}

public List<BookDetails> getBook() {
	return book;
}

public void setBook(List<BookDetails> book) {
	this.book = book;
}

public Customer getCustomer() {
	return customer;
}

public void setCustomer(Customer customer) {
	this.customer = customer;
}

@Override
public String toString() {
	return "OrderInfo [orderId=" + orderId + ", quantity=" + quantity + ", subTotal=" + subTotal + ", total=" + total
			+ ", orderStatus=" + orderStatus + ", paymentMethod=" + paymentMethod + ", book=" + book + ", customer="
			+ customer + "]";
}



}
