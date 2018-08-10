package com.zhongtai.serviceimpl;

import com.zhongtai.dao.ProcessMapper;
import com.zhongtai.pojo.Process;
import com.zhongtai.service.ProcessService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("processService")
public class ProcessServiceImpl implements ProcessService {

    @Resource
    ProcessMapper processMapper;

    @Override
    public List<Process> selectProcess(Integer id) {
        Map params = new HashMap();
        params.put("id",id);
        return processMapper.selectProcess(params);
    }

    @Override
    public void insertProcess(Process process) {
        processMapper.insertProcess(process);
    }

    @Override
    public void deleteProcess(Integer id) {
        processMapper.deleteProcess(id);
    }

    @Override
    public void updateProcess(Process process) {
        processMapper.updateProcess(process);
    }
}
