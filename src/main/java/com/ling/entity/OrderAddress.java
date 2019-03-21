package com.ling.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Description: TODO
 * 
 * @author Lian
 * @Date Aug 22, 2018 3:30:14 PM 
 */
public class OrderAddress implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3730802667312375340L;
	
	@JsonProperty("enigma_order_id")
	private Long orderId;
	
	private String address1;
	
	private String address2;
	
	private String address3;
	
	private String address4;
	
	private String city;
	
	@JsonProperty("state_province")
	private String stateProvince;
	
	@JsonProperty("postal_code")
	private String postalCode;
	
	private String country;

	public Long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getAddress4() {
		return this.address4;
	}

	public void setAddress4(String address4) {
		this.address4 = address4;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateProvince() {
		return this.stateProvince;
	}

	public void setStateProvince(String stateProvince) {
		this.stateProvince = stateProvince;
	}

	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	

}
