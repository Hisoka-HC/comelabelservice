package com.zhongtai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.UsersService;
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
public class UsersController {

    @Resource
    UsersService usersService;

    @RequestMapping(value = "users/insert.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertUsers(HttpSession session, Users users, HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        usersService.insertUsers(users);
        return "success";
    }

    @RequestMapping(value = "users/select.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectUsers(HttpSession session,HttpServletResponse response,HttpServletRequest request,Integer id){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Users> userslist = usersService.selectUsers(id);
        JSONArray array =(JSONArray)JSON.toJSON(userslist);
        return array.toJSONString();
    }

    @RequestMapping(value = "users/update.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateUsers(HttpSession session,Users users,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        usersService.updateUsers(users);
        return "success";
    }

    @RequestMapping(value = "users/delete.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String deleteUsers(HttpSession session, Integer id, HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        usersService.deleteUsers(id);
        return "success";
    }
}
