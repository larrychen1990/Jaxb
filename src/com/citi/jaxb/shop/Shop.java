package com.citi.jaxb.shop;

import java.util.Set;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
 


//同时使用了@XmlType（propOrder={}）和
//@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)，
//但是生成的xml只按照propOrder定义的顺序生成元素

//生成xml文件里面元素的顺序按照propOrder排序
@XmlType(name = "shop", propOrder = { "name", "number", "describer", "address","orders" })
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "CHMart")		//生成xml的跟元素的名字为CHMart
public class Shop {
 
    @XmlAttribute
    private String name;
 
    // @XmlElement
    private String number;
 
    @XmlElement
    private String describer;
    
    @XmlElement
    private Address address;
 
    @XmlElementWrapper(name = "orders")
    @XmlElement(name = "order")
    private Set<Order> orders;
 
    public Shop() {}
 
    public Shop(String name, String number, String describer, Address address) {
        this.name = name;
        this.number = number;
        this.describer = describer;
        this.address = address;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getDescriber() {
		return describer;
	}

	public void setDescriber(String describer) {
		this.describer = describer;
	}

	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

} 