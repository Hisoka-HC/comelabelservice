package com.zhongtai.service;

import com.zhongtai.pojo.Process;

import java.util.List;

public interface ProcessService {
    public List<Process> selectProcess(Integer id);
    public void insertProcess(Process process);
    public void deleteProcess(Integer id);
    public void updateProcess(Process process);
}
