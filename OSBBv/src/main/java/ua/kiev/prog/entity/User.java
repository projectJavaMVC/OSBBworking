package ua.kiev.prog.entity;

import java.math.BigDecimal;

/**
 * Created by mbro8_000 on 26.11.2015.
 */
public class User {
    private long id;
    private String name;
    private String surename;
    private String phone;
    private String email;
    private Integer flatNum;
    private BigDecimal area;
    private Integer peopleCNT;

    public User(UserEntity user){
        this.id = user.getId();
        this.area = user.userInfo.getFlatsEntity().getArea();
        this.email = user.getEmail();
        this.flatNum = user.userInfo.getFlatsEntity().getFlatNumber();
        this.name = user.userInfo.getFirstName();
        this.surename = user.userInfo.getLastName();
        this.peopleCNT = user.userInfo.getFlatsEntity().getPeopleCnt();
        this.phone = user.userInfo.getPhone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getFlatNum() {
        return flatNum;
    }

    public void setFlatNum(Integer flatNum) {
        this.flatNum = flatNum;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    public Integer getPeopleCNT() {
        return peopleCNT;
    }

    public void setPeopleCNT(Integer peopleCNT) {
        this.peopleCNT = peopleCNT;
    }
}
