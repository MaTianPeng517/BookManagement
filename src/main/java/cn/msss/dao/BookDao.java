package cn.msss.dao;

import cn.msss.entity.Book;

import java.io.Serializable;
import java.util.List;

public interface BookDao {

    //查询
    public List<Book> query();
    //条件查询

    //删除
    public boolean amputate(Serializable amputate);

    //修改
    public boolean modify(Serializable modify);

    //添加
    public int  append(Serializable append);
}
