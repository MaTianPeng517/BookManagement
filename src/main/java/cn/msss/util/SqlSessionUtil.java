package cn.msss.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 单列工具
 */
public class SqlSessionUtil {

    private static SqlSessionFactory factory=null;

    private SqlSessionUtil(){

    }

    public static synchronized SqlSession getSqlSession(){
        try {
            InputStream stream = Resources.getResourceAsStream("mybatis.xml");
            factory=new SqlSessionFactoryBuilder().build(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return factory.openSession();
    }
}
