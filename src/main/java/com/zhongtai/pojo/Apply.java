/*    */ package com.zhongtai.pojo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/*    */
/*    */ public class Apply {
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /*    */   private Integer id;
    /*    */   private String name;
    /*    */   private String phone;
    /*    */   private Double money;
    /*    */   private Timestamp datetime;

    @Override
    public String toString() {
        return "Apply{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", money=" + money +
                ", datetime=" + datetime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getDatetime() {
        Calendar calender = Calendar.getInstance();
        Date date = new Date();
        calender.setTime(date);
        return  DATE_FORMAT.format(calender.getTime());
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }
}