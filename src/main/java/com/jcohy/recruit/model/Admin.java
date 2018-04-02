package com.jcohy.recruit.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * ClassName  : com.jcohy.perfectteaching.repository
 * Description  :管理员表
 */
@Entity
@Table(name = "admin")
public class Admin implements Serializable{

    private static final long serialVersionUID = 3L;
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    //编号，使用此信息登录
    private Integer num;
    //名字
    private String name;
    //密码
    private String password;
    //邮箱
    private String email;
    //性别
    private String sex;
    //出生日期
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date birth;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
