package com.citi.jaxb.shop;

import java.math.BigDecimal;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
 

//@XmlAccessorType(XmlAccessType.FIELD)，
//所以此处注释掉了@XmlElement，xml中依然会生成这些元素

@XmlType(name="order",propOrder={"orderNumber","shopName","price","amount","purDate","customer"})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Order {
 
	@XmlAttribute
	private String orderNumber;
	
//  @XmlElement　　
    private String shopName;
 
//  @XmlElement
    private BigDecimal price;
    
//  @XmlElement
    private int amount;
 
//  @XmlElement
    @XmlJavaTypeAdapter(value=DateAdapter.class)
    private Date purDate;
 
 
//  @XmlElement
    private Customer customer;
 
    public Order() {
    }
 
    public Order(String shopName, String orderNumber, Date purDate,
            BigDecimal price, int amount) {
        this.shopName = shopName;
        this.orderNumber = orderNumber;
        this.purDate = purDate;
        this.price = price;
        this.amount = amount;
    }

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getPurDate() {
		return purDate;
	}

	public void setPurDate(Date purDate) {
		this.purDate = purDate;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    
}
