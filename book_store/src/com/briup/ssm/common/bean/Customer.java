package com.briup.ssm.common.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

/**
 *
 *
 * @author 刘真
 * @date 2018/7/30 19:36
 * @telephone 17770823458
 */

/**
 * 用户类
 * */
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 用户id,主键
	 * */
	private Long id;

	/**
	 * 用户名
	 * */
	private String name;

	/**
	 * 密码
	 * */
	private String password;

    /**
     * 国家
     * */
	private String country;

    /**
     * 省份
     * */
	private String province;

    /**
     * 城市
     * */
	private String city;

    /**
     * 详细地址1
     * */
	private String street1;

    /**
     * 详细地址2
     * */
	private String street2;

	/**
	 * 邮编
	 * */
	private String zip;

	/**
	 * 家庭号码
	 * */
	private String homephone;

    /**
     * 工作号码
     * */
	private String officephone;

    /**
     * 手机号码
     * */
	private String cellphone;

	/**
	 * email
	 * */
	private String email;

	/**
	 * 用户所有订单,关联关系 - 一对多
	 * */
	private Set<Order> orders = new HashSet<Order>();
	
	public Customer(){
		
	}

    public Customer(Long id, String name, String password, String country, String province, String city, String street1, String street2, String zip, String homephone, String officephone, String cellphone, String email, Set<Order> orders) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.country = country;
        this.province = province;
        this.city = city;
        this.street1 = street1;
        this.street2 = street2;
        this.zip = zip;
        this.homephone = homephone;
        this.officephone = officephone;
        this.cellphone = cellphone;
        this.email = email;
        this.orders = orders;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getHomephone() {
        return homephone;
    }

    public void setHomephone(String homephone) {
        this.homephone = homephone;
    }

    public String getOfficephone() {
        return officephone;
    }

    public void setOfficephone(String officephone) {
        this.officephone = officephone;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", zip='" + zip + '\'' +
                ", homephone='" + homephone + '\'' +
                ", officephone='" + officephone + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
