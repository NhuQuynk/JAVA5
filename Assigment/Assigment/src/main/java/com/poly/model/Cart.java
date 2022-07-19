package com.poly.model;

import java.math.BigDecimal;
import java.math.BigInteger;

import lombok.Data;
@Data
public class Cart {

	// Key: ma san pham, Value: so luong san pham
	private  HeoDTO heo;
	private BigDecimal price;
	private int quantity;
	public HeoDTO getHeo() {
		return heo;
	}
	public void setHeo(HeoDTO heo) {
		this.heo = heo;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	
	
}
