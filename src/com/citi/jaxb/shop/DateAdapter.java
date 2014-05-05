package com.citi.jaxb.shop;

import java.util.Date;
import java.text.SimpleDateFormat;
 
import javax.xml.bind.annotation.adapters.XmlAdapter;
 
////用于格式化日期在xml中的显示格式，
//并且由xml unmarshal为java对象时，将字符串解析为Date对象
public class DateAdapter extends XmlAdapter<String, Date> {
 
    private String pattern = "yyyy-MM-dd HH:mm:ss";
    SimpleDateFormat fmt = new SimpleDateFormat(pattern);
     
    @Override
    public Date unmarshal(String dateStr) throws Exception {
         
        return fmt.parse(dateStr);
    }
 
    @Override
    public String marshal(Date date) throws Exception {
         
        return fmt.format(date);
    }
 
}
