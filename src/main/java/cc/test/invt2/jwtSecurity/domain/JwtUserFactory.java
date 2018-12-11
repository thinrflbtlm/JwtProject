/******************************************************************************
 * Copyright (c) 2017-2018. Spring-Boot -Version 2.1.0.RELEASE                *
 * JwtUserFactory.java  181209 01:51:26 by @Chenccsy                          *
 * JavaProject builded by IDE@ ,all rights reserved.                          *
 ******************************************************************************/

package cc.test.invt2.jwtSecurity.domain;

import cc.test.invt2.domain.Authority;
import cc.test.invt2.domain.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtUserFactory {

     private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
       return new JwtUser(
                user.getUserid2(), user.getUsername(), user.getUserpwd(), user.getUserstate() == 1 ? true : false,
                user.getLastPasswordResetDate(), mapToAuthority(user.getAuthorityList()),
                user.getUseremail(), user.getLoginTime(), user.getAcount().getRealname(), user.getUserproblem(),user.getUseranswer());
    }

    private static Collection<? extends GrantedAuthority> mapToAuthority(List<Authority> list) {
        return list.stream().map(
                authority -> new SimpleGrantedAuthority(
                        authority.getName().name()
                )
        ).collect(Collectors.toList());
    }


}
