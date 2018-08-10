package com.zhongtai.service;

import com.zhongtai.pojo.Customers;

import java.util.List;

public interface CustomersService {

    public List<Customers> selectCustomers();
    public List<Customers> selectPersonalCustomers();
    public List<Customers> selectLike(String search);
    public void insertCustomers(Customers customers);
    public void deleteCustomers(Integer id);
    public void updateCustomers(Customers customers);
}
