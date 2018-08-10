package com.zhongtai.service;

import com.zhongtai.pojo.Users;

import java.util.List;

public interface UsersService {

    public List<Users> selectUsers(Integer id);
    public Users login(Users users);
    public void insertUsers(Users users);
    public void deleteUsers(Integer id);
    public void updateUsers(Users users);
}
