package com.zhongtai.dao;

import com.zhongtai.pojo.Customers;
import com.zhongtai.pojo.Process;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomersMapper {
    public List<Customers> selectCustomers();
    public List<Customers> selectPersonalCustomers(Map<String, Object> params);
    public List<Customers> selectLike(Map<String, Object> params);
    public List<Process> selectWhereId(Integer id);
    public List<Process> selectById(Integer id);
    public void insertCustomers(Customers customers);
    public void deleteCustomers(Integer id);
    public void updateCustomers(Customers customers);
}
