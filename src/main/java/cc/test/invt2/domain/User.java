/******************************************************************************
 * Copyright (c) 2017-2018. Spring-Boot -Version 2.1.0.RELEASE                *
 * User.java  181209 01:55:02 by @Chenccsy                                    *
 * JavaProject builded by IDE@ ,all rights reserved.                          *
 ******************************************************************************/

package cc.test.invt2.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User  implements Serializable {
    private Acount acount;
    private Integer userid2;
    private Integer acountid;
    private String username;
    private String useremail;
    private String userpwd;
    private String usersex;
    private String userproblem;
    private String useranswer;
    private String invitedcode;
    private String invitecode;
    private Integer userstate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastPasswordResetDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date loginTime;



    private List<Authority> authorityList;
    {
        authorityList =new ArrayList<Authority>();
        authorityList.add(new Authority(1,AuthorityName.ROLE_USER,"普通用户"));

    }

    public List<Authority> getAuthorityList() {
        return authorityList;
    }

    public void setAuthorityList(List<Authority> authorityList) {

//        this.authorityList = authorityList;
//
        authorityList =new ArrayList<Authority>();
        authorityList.add(new Authority(1,AuthorityName.ROLE_USER,"普通用户"));
        this.authorityList = authorityList;
    }


    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Date lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

    public Integer getUserstate() {
        return userstate;
    }

    public void setUserstate(Integer userstate) {
        this.userstate = userstate;
    }

    public Integer getUserid2() {
        return userid2;
    }

    public void setUserid2(Integer userid2) {
        this.userid2 = userid2;
    }

    public Integer getAcountid() {
        return acountid;
    }

    public void setAcountid(Integer acountid) {
        this.acountid = acountid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "acount=" + acount +
                ", userid2=" + userid2 +
                ", acountid=" + acountid +
                ", username='" + username + '\'' +
                ", useremail='" + useremail + '\'' +
                ", userpwd='" + userpwd + '\'' +
                ", usersex='" + usersex + '\'' +
                ", userproblem='" + userproblem + '\'' +
                ", useranswer='" + useranswer + '\'' +
                ", invitedcode='" + invitedcode + '\'' +
                ", invitecode='" + invitecode + '\'' +
                ", userstate=" + userstate +
                ", lastPasswordResetDate=" + lastPasswordResetDate +
                ", loginTime=" + loginTime +
                ", authorityList=" + authorityList +
                '}';
    }

    public Acount getAcount() {
        return acount;
    }

    public void setAcount(Acount acount) {
        this.acount = acount;
    }

    public String getUsersex() {
        return usersex;
    }

    public void setUsersex(String usersex) {
        this.usersex = usersex;
    }

    public String getUserproblem() {
        return userproblem;
    }

    public void setUserproblem(String userproblem) {
        this.userproblem = userproblem;
    }

    public String getUseranswer() {
        return useranswer;
    }

    public void setUseranswer(String useranswer) {
        this.useranswer = useranswer;
    }

    public String getInvitedcode() {
        return invitedcode;
    }

    public void setInvitedcode(String invitedcode) {
        this.invitedcode = invitedcode;
    }

    public String getInvitecode() {
        return invitecode;
    }

    public void setInvitecode(String invitecode) {
        this.invitecode = invitecode;
    }

    public User(Acount acount, Integer userid2, Integer acountid, String username, String useremail, String userpwd, String usersex, String userproblem, String useranswer, String invitedcode, String invitecode, Integer userstate, Timestamp lastPasswordResetDate, Timestamp loginTime, List<Authority> authorityList) {
        this.acount = acount;
        this.userid2 = userid2;
        this.acountid = acountid;
        this.username = username;
        this.useremail = useremail;
        this.userpwd = userpwd;
        this.usersex = usersex;
        this.userproblem = userproblem;
        this.useranswer = useranswer;
        this.invitedcode = invitedcode;
        this.invitecode = invitecode;
        this.userstate = userstate;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.loginTime = loginTime;
        this.authorityList = authorityList;
    }

    public User() {
    }
}
