package com.briup.ssm.common.bean;

import java.io.Serializable;

/**
 *
 *
 * @author 刘真
 * @date 2018/7/30 19:31
 * @telephone 17770823458
 */

/**
 * 书籍类
 * */
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;

    /**
     * 书籍id,主键
     * */
	private Long id;

    /**
     * 书籍名字
     * */
	private String name;

    /**
     * 书籍作者
     * */
	private String author;

    /**
     * 书籍价格
     * */
	private Double price;

    /**
     * 书籍出版社
     * */
	private String publish;

    /**
     * 书籍页数
     * */
	private String page;

    /**
     * 书籍分类
     * */
	private String sort;

    /**
     * 书籍介绍
     * */
	private String introduction;
	
	public Book(){
		
	}

    public Book(Long id, String name, String author, Double price, String publish, String page, String sort, String introduction) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
        this.publish = publish;
        this.page = page;
        this.sort = sort;
        this.introduction = introduction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                ", publish='" + publish + '\'' +
                ", page='" + page + '\'' +
                ", sort='" + sort + '\'' +
                ", introduction='" + introduction + '\'' +
                '}';
    }
}
