package cn.msss.entity;

import java.io.Serializable;

/**
 * 图书信息
 */
public class Book implements Serializable{

    private int id;                 //编号
    private String book_name;        //名称
    private String book_author;     //作者
    private double book_price;      //单价
    private int book_number;        //数量

    public Book(int id, String book_name, String book_author, double book_price, int book_number) {
        this.id = id;
        this.book_name = book_name;
        this.book_author = book_author;
        this.book_price = book_price;
        this.book_number = book_number;
    }

    public Book() {

    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", book_name='" + book_name + '\'' +
                ", book_author='" + book_author + '\'' +
                ", book_price=" + book_price +
                ", book_number=" + book_number +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public String getBook_author() {
        return book_author;
    }

    public void setBook_author(String book_author) {
        this.book_author = book_author;
    }

    public double getBook_price() {
        return book_price;
    }

    public void setBook_price(double book_price) {
        this.book_price = book_price;
    }

    public int getBook_number() {
        return book_number;
    }

    public void setBook_number(int book_number) {
        this.book_number = book_number;
    }
}
