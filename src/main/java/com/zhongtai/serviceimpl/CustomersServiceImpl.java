package com.zhongtai.serviceimpl;

import com.zhongtai.dao.CustomersMapper;
import com.zhongtai.pojo.Customers;
import com.zhongtai.pojo.Process;
import com.zhongtai.service.CustomersService;
import com.zhongtai.util.HttpUtils;
import com.zhongtai.util.SendMessageUtil;
import org.apache.http.HttpResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("customersService")
public class CustomersServiceImpl implements CustomersService {

    @Resource
    CustomersMapper customersMapper;

    @Override
    public List<Customers> selectCustomers() {
        //Map params = new HashMap();
        return customersMapper.selectCustomers();
    }

    @Override
    public List<Customers> selectPersonalCustomers() {
        Map params = new HashMap();
        return customersMapper.selectPersonalCustomers(params);
    }

    @Override
    public List<Customers> selectLike(String search) {
        Map params = new HashMap();
        params.put("search",search);
        return customersMapper.selectLike(params);
    }

    @Override
    public void insertCustomers(Customers customers) {
        customersMapper.insertCustomers(customers);
    }

    @Override
    public void deleteCustomers(Integer id) {
        customersMapper.deleteCustomers(id);
    }


    /**
     * 没写完  =====================================================
     * @param customers
     */
    @Override
    public void updateCustomers(Customers customers) {
        Integer id = customers.getId();
        List<Process> listFormer = customersMapper.selectWhereId(id);
        String formerName = listFormer.get(0).getMessage();
        customersMapper.updateCustomers(customers);

        List<Process> list = customersMapper.selectWhereId(id);
        String updateName = list.get(0).getMessage();

        if (formerName!=updateName){
            SendMessageUtil.sendProcess(list.get(0).getPhone(),updateName);
        }

    }



}
