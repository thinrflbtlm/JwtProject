/******************************************************************************
 * Copyright (c) 2017-2018. Spring-Boot -Version 2.1.0.RELEASE                *
 * JwtUser.java  181209 01:51:26 by @Chenccsy                                 *
 * JavaProject builded by IDE@ ,all rights reserved.                          *
 ******************************************************************************/

package cc.test.invt2.jwtSecurity.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

/**
 * 实现接口类型是security管理的用户
 */
public class JwtUser implements UserDetails {
    //    必须存在的属性和属性名
    private final Integer id;

    private final String username;
    @JsonIgnore
    private final String password;
    private final boolean enabled; //是否启用
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private final Date lastPasswordResetDate;
    private final Collection<? extends GrantedAuthority> authorities;
    //    可选添加

    private final String email;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private final Date loginTime;

    private final String realname;
    private final String userproblem;
    private final String useranswer;

    public String getRealname() {
        return realname;
    }

    public String getUserproblem() {
        return userproblem;
    }

    public String getUseranswer() {
        return useranswer;
    }

    @Override
    public String toString() {
        return "JwtUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", lastPasswordResetDate=" + lastPasswordResetDate +
                ", authorities=" + authorities +
                ", email='" + email + '\'' +
                ", loginTime=" + loginTime +
                '}';
    }


    public Integer getId() {
        return id;
    }

    @JsonIgnore
    public Date getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }


    public String getEmail() {
        return email;
    }

    public Date getLoginTime() {
        return loginTime;
    }


    //    由于属性是final，所以只能使用构造器进行生成
    public JwtUser(Integer id, String username, String password, boolean enabled, Date lastPasswordResetDate, Collection<? extends GrantedAuthority> authorities, String email, Date loginTime, String realname, String userproblem, String useranswer) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.lastPasswordResetDate = lastPasswordResetDate;
        this.authorities = authorities;
        this.email = email;
        this.loginTime = loginTime;
        this.realname = realname;
        this.userproblem = userproblem;
        this.useranswer = useranswer;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    /**
     * 没有过期吗
     *
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 没被锁定吗
     *
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 凭证没过期吗
     *
     * @return
     */
    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }
}
