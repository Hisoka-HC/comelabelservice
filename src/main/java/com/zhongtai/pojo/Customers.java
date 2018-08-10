 package com.zhongtai.pojo;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

 public class Customers{
     public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

   private Integer id;
   private String name;
   private String number;
   private String phone;
   private Integer organizeId;
   private Double applyMoney;
  private Integer processId;
  private Double borrowMoney;
  private Integer userId;
  private Timestamp submitDatetime;
  private Process process;
  private Organization organization;
  private Users users;

     @Override
     public String toString() {
         return "Customers{" +
                 "id=" + id +
                 ", name='" + name + '\'' +
                 ", number='" + number + '\'' +
                 ", phone='" + phone + '\'' +
                 ", organizeId=" + organizeId +
                 ", applyMoney=" + applyMoney +
                 ", processId=" + processId +
                 ", borrowMoney=" + borrowMoney +
                 ", userId=" + userId +
                 ", submitDatetime=" + submitDatetime +
                 ", process=" + process +
                 ", organization=" + organization +
                 ", users=" + users +
                 '}';
     }

     public String getSubmitDatetime() {
         Calendar calender = Calendar.getInstance();
         Date date = new Date();
         calender.setTime(date);
         return  DATE_FORMAT.format(calender.getTime());
     }

     public void setSubmitDatetime(Timestamp datetime) {
         this.submitDatetime = datetime;
     }

     public Process getProcess() {
         return process;
     }

     public void setProcess(Process process) {
         this.process = process;
     }

     public Organization getOrganization() {
         return organization;
     }

     public void setOrganization(Organization organization) {
         this.organization = organization;
     }

     public Users getUsers() {
         return users;
     }

     public void setUsers(Users users) {
         this.users = users;
     }

     public Integer getOrganizeId() {
         return organizeId;
     }

     public void setOrganizeId(Integer organizeId) {
         this.organizeId = organizeId;
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

     public String getNumber() {
         return number;
     }

     public void setNumber(String number) {
         this.number = number;
     }

     public String getPhone() {
         return phone;
     }

     public void setPhone(String phone) {
         this.phone = phone;
     }

     public Double getApplyMoney() {
         return applyMoney;
     }

     public void setApplyMoney(Double applyMoney) {
         this.applyMoney = applyMoney;
     }

     public Integer getProcessId() {
         return processId;
     }

     public void setProcessId(Integer processId) {
         this.processId = processId;
     }

     public Double getBorrowMoney() {
         return borrowMoney;
     }

     public void setBorrowMoney(Double borrowMoney) {
         this.borrowMoney = borrowMoney;
     }

     public Integer getUserId() {
         return userId;
     }

     public void setUserId(Integer userId) {
         this.userId = userId;
     }


 }




