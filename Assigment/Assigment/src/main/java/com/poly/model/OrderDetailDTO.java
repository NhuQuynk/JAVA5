package com.poly.model;
import java.math.BigDecimal;

import lombok.Data;
@Data
public class OrderDetailDTO {
	private Integer id;

	private int quantity;

	private BigDecimal price;

	private HeoDTO heo;

	private OrderDTO order;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public HeoDTO getHeo() {
		return heo;
	}

	public void setHeo(HeoDTO heo) {
		this.heo = heo;
	}

	public OrderDTO getOrder() {
		return order;
	}

	public void setOrder(OrderDTO order) {
		this.order = order;
	}
	
}
