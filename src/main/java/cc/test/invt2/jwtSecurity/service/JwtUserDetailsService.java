/******************************************************************************
 * Copyright (c) 2017-2018. Spring-Boot -Version 2.1.0.RELEASE                *
 * JwtUserDetailsService.java  181209 01:51:27 by @Chenccsy                   *
 * JavaProject builded by IDE@ ,all rights reserved.                          *
 ******************************************************************************/

package cc.test.invt2.jwtSecurity.service;

import cc.test.invt2.domain.User;
import cc.test.invt2.jwtSecurity.domain.JwtUserFactory;
import cc.test.invt2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service()
@Transactional(propagation = Propagation.NOT_SUPPORTED,readOnly = true)
public class JwtUserDetailsService implements UserDetailsService {
    @Autowired
    private UserMapper usermapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =usermapper.findByName(username);
        if(user == null){
            throw new UsernameNotFoundException("用户名不存在！");
        }else {
            return JwtUserFactory.create(user);
        }
    }


}
