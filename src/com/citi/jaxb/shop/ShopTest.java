package com.citi.jaxb.shop;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
 
public class ShopTest {
 
    public static void main(String[] args) throws JAXBException, IOException{
        Set<Order> orders = new HashSet<Order>();
         
        Address address1 = new Address("China", "ShangHai", "ShangHai", "Huang", "200000");
        Customer customer1 = new Customer("Jim", "male", "13699990000", address1);
        Order order1 = new Order("Mart", "LH59900", new Date(), new BigDecimal(60), 1);
        order1.setCustomer(customer1);
         
        Address address2 = new Address("China", "JiangSu", "NanJing", "ZhongYangLu", "210000");
        Customer customer2 = new Customer("David", "male", "13699991000", address2);
        Order order2 = new Order("Mart", "LH59800", new Date(), new BigDecimal(80), 1);
        order2.setCustomer(customer2);
         
        orders.add(order1);
        orders.add(order2);
         
        Address address3 = new Address("China", "ZheJiang", "HangZhou", "XiHuRoad", "310000");
        Shop shop = new Shop("CHMart", "100000", "EveryThing",address3);
        shop.setOrders(orders);
         
         
        JAXBContext context = JAXBContext.newInstance(Shop.class);
        File file=new File("shop.xml");
        try {
            Marshaller marshal = context.createMarshaller();
            
         // 编码格式
            marshal.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
         // 是否格式化生成的XML
            marshal.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
         // 是否省略XML头信息<?xml version="1.0" encoding="utf-8" standalone="yes"?>
            marshal.setProperty(Marshaller.JAXB_FRAGMENT, false);
            
            marshal.marshal(shop, file);		//生成xml文件
            marshal.marshal(shop, System.out);
        } catch (Exception e) {
            e.printStackTrace();
        }
         
        Unmarshaller unmarshal = context.createUnmarshaller();
        Shop shop1 = (Shop)unmarshal.unmarshal(file);			//获取xml文件
         
        Set<Order> orders1 = shop1.getOrders();
        for(Order order : orders1){
            System.out.println("***************************");
            System.out.println(order.getOrderNumber());
            System.out.println(order.getCustomer().getName());
            System.out.println("***************************");
        }
    }
}
