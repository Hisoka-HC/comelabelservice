package com.zhongtai.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhongtai.pojo.Process;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.ProcessService;
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
public class ProcessController {

    @Resource
    ProcessService processService;

    @RequestMapping(value = "process/select.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String selectProcess(HttpSession session, HttpServletResponse response,HttpServletRequest request,Integer id){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        List<Process> list = processService.selectProcess(id);
        JSONArray array=(JSONArray) JSON.toJSON(list);
        return array.toJSONString();
    }

    @RequestMapping(value = "process/insert.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String insertProcess(HttpSession session,Process process,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        processService.insertProcess(process);
        return "success";
    }

    @RequestMapping(value = "process/update.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String updateProcess(HttpSession session,Process process,HttpServletResponse response,HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        processService.updateProcess(process);
        return "success";
    }

    @RequestMapping(value = "process/delete.do", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String deleteProcess(HttpSession session, Integer id, HttpServletResponse response, HttpServletRequest request){
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        Users user = GetUserSession.getSessionUser(session);
        if (user==null){
            return "failed";
        }
        processService.deleteProcess(id);
        return "success";
    }
}
