/******************************************************************************
 * Copyright (c) 2017-2018. Spring-Boot -Version 2.1.0.RELEASE                *
 * Acount.java  181209 06:40:50 by @Chenccsy                                  *
 * JavaProject builded by IDE@ ,all rights reserved.                          *
 ******************************************************************************/

package cc.test.invt2.domain;

import java.io.Serializable;

/**
 * 账户信息
 */
public class Acount implements Serializable{

    private String aphone;//手机号
    private Float afrozen;//冻结资金
    private Integer apayment;//支付密码
    private String acard;//身份证
    private Character aquaity;//信用等级
    private Float abalance;//账户余额
    private Integer acount;//账户编号
    private Integer userid;//用户编号2
    private String realname;

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    @Override
    public String toString() {
        return "Acount{" +
                "aphone='" + aphone + '\'' +
                ", afrozen=" + afrozen +
                ", apayment=" + apayment +
                ", acard='" + acard + '\'' +
                ", aquaity=" + aquaity +
                ", abalance=" + abalance +
                ", acount=" + acount +
                ", userid=" + userid +
                '}';
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public Float getAfrozen() {
        return afrozen;
    }

    public void setAfrozen(Float afrozen) {
        this.afrozen = afrozen;
    }

    public Integer getApayment() {
        return apayment;
    }

    public void setApayment(Integer apayment) {
        this.apayment = apayment;
    }

    public String getAcard() {
        return acard;
    }

    public void setAcard(String acard) {
        this.acard = acard;
    }

    public Character getAquaity() {
        return aquaity;
    }

    public void setAquaity(Character aquaity) {
        this.aquaity = aquaity;
    }

    public Float getAbalance() {
        return abalance;
    }

    public void setAbalance(Float abalance) {
        this.abalance = abalance;
    }

    public Integer getAcount() {
        return acount;
    }

    public void setAcount(Integer acount) {
        this.acount = acount;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
}
