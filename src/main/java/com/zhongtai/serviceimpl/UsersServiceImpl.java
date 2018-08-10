package com.zhongtai.serviceimpl;

import com.zhongtai.dao.UsersMapper;
import com.zhongtai.pojo.Users;
import com.zhongtai.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("usersService")
public class UsersServiceImpl implements UsersService {

    @Resource
    UsersMapper usersMapper;

    @Override
    public List<Users> selectUsers(Integer id) {
        Map params = new HashMap();
        params.put("id",id);
        return usersMapper.selectUsers(params);
    }

    @Override
    public Users login(Users users) {
        Map params = new HashMap();
        params.put("username",users.getUsername());
        params.put("password",users.getPassword());
        return usersMapper.login(params);
    }

    @Override
    public void insertUsers(Users users) {

        usersMapper.insertUsers(users);
    }

    @Override
    public void deleteUsers(Integer id) {
        usersMapper.deleteUsers(id);
    }

    @Override
    public void updateUsers(Users users) {
        usersMapper.updateUsers(users);
    }
}
