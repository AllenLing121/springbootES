package com.ling.entity;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Description: TODO
 * 
 * @author Lian
 * @Date Mar 6, 2019 10:46:01 AM 
 */
public class OrderStatusRequest implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -218919296985703526L;
	
	@JsonProperty("order_status")
	private List<OrderStatus> orderStatus;
	
	public List<OrderStatus> getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(List<OrderStatus> orderStatus) {
		this.orderStatus = orderStatus;
	}

}
class OrderStatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("enigma_order_id")
	private Long enigmaOrderId;
	
	private String status;
	
	@JsonProperty("item_sku")
	private String itemSku;
	
	public Long getEnigmaOrderId() {
		return this.enigmaOrderId;
	}
	
	public void setEnigmaOrderId(Long enigmaOrderId) {
		this.enigmaOrderId = enigmaOrderId;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getItemSku() {
		return this.itemSku;
	}
	
	public void setItemSku(String itemSku) {
		this.itemSku = itemSku;
	}
}
