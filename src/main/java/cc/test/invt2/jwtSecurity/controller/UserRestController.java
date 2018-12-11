/******************************************************************************
 * Copyright (c) 2017-2018. Spring-Boot -Version 2.1.0.RELEASE                *
 * UserRestController.java  181209 01:51:27 by @Chenccsy                      *
 * JavaProject builded by IDE@ ,all rights reserved.                          *
 ******************************************************************************/

package cc.test.invt2.jwtSecurity.controller;

import cc.test.invt2.jwtSecurity.JwtTokenUtil;
import cc.test.invt2.jwtSecurity.domain.JwtUser;
import cc.test.invt2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取已授权用户信息
 *
 *
 */
@RestController
@RequestMapping("/api")
public class UserRestController {

  @Value("${jwt.header}")
  private String tokenHeader;

  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
  private UserMapper userMapper;

  @Autowired
//  指定service的接口id，相当于向上转型 UserDetailsService userDetailsService = new JwtUserDetailsService（）；
  @Qualifier("jwtUserDetailsService")
  private UserDetailsService userDetailsService;

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  @PreAuthorize("hasRole('USER')")
  public JwtUser getAuthenticatedUser(HttpServletRequest request) {
    String token = request.getHeader(tokenHeader).substring(7);
    String username = jwtTokenUtil.getUsernameFromToken(token);
    JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

    userMapper.updatelogintime(user.getUsername());

    return user;
  }

}
