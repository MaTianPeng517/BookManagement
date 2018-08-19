package cn.msss.dao;

import cn.msss.entity.Users;

import java.io.Serializable;
import java.util.List;

public interface UserDao {

    //登录
    public List<Users> login(Users login);
}
