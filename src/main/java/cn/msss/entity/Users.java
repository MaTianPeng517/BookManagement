package cn.msss.entity;

import java.io.Serializable;

/**
 * 登录信息
 */
public class Users implements Serializable {

    private int id;                 //编号
    private String users_name;      //用户名
    private String user_pwd;        //密码

    public Users() {
    }

    public Users(int id, String users_name, String user_pwd) {
        this.id = id;
        this.users_name = users_name;
        this.user_pwd = user_pwd;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", users_name='" + users_name + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsers_name() {
        return users_name;
    }

    public void setUsers_name(String users_name) {
        this.users_name = users_name;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }
}
