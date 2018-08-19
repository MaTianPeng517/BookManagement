package cn.msss.util;

import cn.msss.dao.BookDao;
import cn.msss.dao.UserDao;
import cn.msss.entity.Book;
import cn.msss.entity.Users;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input=new Scanner(System.in);
    static SqlSession session=SqlSessionUtil.getSqlSession();
    static BookDao bookDao=session.getMapper(BookDao.class);
    static UserDao userDao=session.getMapper(UserDao.class);
    static Book book=new Book();
    static Users users=new Users();

    public static void main(String[] args) {
        //登录
        login();
    }
    //添加
    private static void append() {
        System.out.println("输入图书名称：");
        String book_name=input.next();
        book.setBook_name(book_name);
        System.out.println("输入图书作者：");
        String book_author=input.next();
        book.setBook_author(book_author);
        System.out.println("输入图书单价：");
        double book_price=input.nextDouble();
        book.setBook_price(book_price);
        System.out.println("输入图书数量：");
        int book_number=input.nextInt();
        book.setBook_number(book_number);
        int append = bookDao.append(book);
        if (append>0){
            System.out.println("成功");
            //提交加释放资源
            after();
            query();
        }else{
            System.out.println("失败");
        }

    }
    //删除
    private static void amputate() {
        query();
        System.out.println("选择ID编号：");
        int a=input.nextInt();
        book.setId(a);
        boolean amputate = bookDao.amputate(book);
        if(amputate){
            System.out.println("成功");
            //提交加释放资源
            after();
        }else {
            System.out.println("失败");
        }
    }
    //修改
    private static void modify() {
        query();
        System.out.println("选择修改的编号：");
        int a=input.nextInt();
        book.setId(a);

        System.out.println("修改的名称：");
        String book_name=input.next();
        book.setBook_name(book_name);

        System.out.println("修改的作者：");
        String book_author=input.next();
        book.setBook_author(book_author);

        System.out.println("修改的单价：");
        double book_price=input.nextDouble();
        book.setBook_price(book_price);

        System.out.println("修改的数量：");
        int book_number=input.nextInt();
        book.setBook_number(book_number);

        boolean modify = bookDao.modify(book);
        if (modify){
            System.out.println("成功");
            //提交加释放资源
            after();
        }else{
            System.out.println("失败");
        }
    }
    //查询
    private static void query() {
        List<Book> query = bookDao.query();
        for (Book book:query) {
            System.out.println("图书编号"+book.getId()+"图书名称:"+book.getBook_name()+"\t图书作者:"+book.getBook_author()+"\t图书单价(元):"+book.getBook_price()+"\t图书数量:"+book.getBook_number());
        }
    }
    //提交加释放资源
    public static void after(){
        session.commit();
        session.close();
    }
    //登录
    public static void login(){
        String y=null;
        do {
            System.out.println("---------------登录---------------");
            System.out.print("输入用户名：");
            String user_name=input.next();
            users.setUsers_name(user_name);
            System.out.print("输入密码：");
            String user_pwd=input.next();
            users.setUser_pwd(user_pwd);
            List<Users> login = userDao.login(users);
            if (login!=null){
                System.out.println("登录成功");
                program();
            }else{
                System.out.println("登录失败(Y/N)Y:返回、N：退出:");
                y=input.next();
            }
        }while (y.equalsIgnoreCase("Y"));
    }
    //开始
    public static void program(){
        System.out.println("-------------------------------------------");
        System.out.println("|     欢迎进入图书                         |");
        System.out.println("|     1.查询，2.修改，3.删除，4.添加        |");
        System.out.println("-------------------------------------------");
        System.out.print("|     请选择：");
        int a=input.nextInt();
        switch (a){
            //查询
            case 1:
                query();
                break;
            //修改
            case 2:
                modify();
                break;
            //删除
            case 3:
                amputate();
                break;
            //添加
            case 4:
                append();
                break;
            //都没选
            default:
                System.out.println("请选择正确的！！！！！");
                break;
        }
    }
}
