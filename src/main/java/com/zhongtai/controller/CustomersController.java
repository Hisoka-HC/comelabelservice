package com.zhongtai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhongtai.pojo.Customers;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.CustomersService;
import com.zhongtai.util.GetUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CustomersController {

    @Resource
    CustomersService customersService;

    @RequestMapping(value = "customers/select.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectCustomers(HttpSession session, HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Customers> list = customersService.selectCustomers();
        JSONArray array =(JSONArray) JSON.toJSON(list);
        return array.toJSONString();
    }

    /**
     * 查找个人客户：没人推荐人的客户
     * @return
     */
    @RequestMapping(value = "customers/selectPersonal.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectPersonalCustomers(HttpSession session,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Customers> list = customersService.selectPersonalCustomers();
        JSONArray array =(JSONArray) JSON.toJSON(list);
        return array.toJSONString();
    }

    @RequestMapping(value = "customers/selectLike.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectLike(HttpSession session,String search,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Customers> list = customersService.selectLike(search);
        JSONArray array =(JSONArray) JSON.toJSON(list);
        return array.toJSONString();
    }

    @RequestMapping(value = "customers/insert.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertCustomers(HttpSession session,Customers customers,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        customersService.insertCustomers(customers);
        return "success";
    }

    /*@RequestMapping(value = "customers/update.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateCustomers(HttpSession session,Customers customers,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        customersService.updateCustomers(customers);

        return "success";
    }*/

    @RequestMapping(value = "customers/delete.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String deleteCustomers(HttpSession session,Integer id,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        customersService.deleteCustomers(id);
        return "success";
    }
}
