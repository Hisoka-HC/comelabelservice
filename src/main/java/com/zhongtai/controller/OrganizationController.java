package com.zhongtai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhongtai.pojo.Organization;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.OrganizationService;
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
public class OrganizationController {

    @Resource
    OrganizationService organizationService;

    @RequestMapping(value = "organization/select.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectOrganization(HttpSession session, HttpServletResponse response, HttpServletRequest request,Integer id){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Organization> list = organizationService.selectOrganization(id);
        JSONArray array = (JSONArray) JSON.toJSON(list);
        return array.toJSONString();
    }

    @RequestMapping(value = "organization/insert.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertOrganization(HttpSession session,Organization organization,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        organizationService.insertOrganization(organization);
        return "success";
    }

    @RequestMapping(value = "organization/update.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateOrganization(HttpSession session,Organization organization,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        organizationService.updateOrganization(organization);
        return "success";
    }

    @RequestMapping(value = "organization/delete.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String deleteOrganization(HttpSession session,Integer id,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        organizationService.deleteOrganization(id);
        return "success";
    }
}
