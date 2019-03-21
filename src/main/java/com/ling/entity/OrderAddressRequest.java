package com.ling.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @Description: TODO
 * 
 * @author Lian
 * @Date Mar 6, 2019 11:17:47 AM 
 */
public class OrderAddressRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3489603182773966967L;
	
	@JsonProperty("order_address")
	private OrderAddress orderAddress;
	
	public OrderAddress getOrderAddress() {
		return this.orderAddress;
	}
	public void setOrderAddress(OrderAddress orderAddress) {
		this.orderAddress = orderAddress;
	}
}
