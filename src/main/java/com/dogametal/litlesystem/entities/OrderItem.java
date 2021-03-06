package com.dogametal.litlesystem.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dogametal.litlesystem.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId //This is to ignore created id unnecessary needs to instance id
	private OrderItemPK id = new OrderItemPK();
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {		
	}

	public OrderItem(Orders order, Product product, Integer quantity, Double price) {
		this.quantity = quantity;
		this.price = price;
		//set id´s to order item auxiliary class
		id.setOrder(order);
		id.setProduct(product);
	}
	
	@JsonIgnore //auxiliary class not exists info id order used here this Json as stopped end point for infinite looping on Postman
	public Orders getOrder() {
		//get info from auxiliary class OrderItemPK
		return id.getOrder();
	}
	
	public void setOrder(Orders order) {
		//Set info to auxiliary class OrderItemPK		
		id.setOrder(order);
	}
	

	public Product getProduct() {
		//get info from auxiliary class OrderItemPK
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		//Set info to auxiliary class OrderItemPK		
		id.setProduct(product);
	}	

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getSubTotal() {
		return price * quantity;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
