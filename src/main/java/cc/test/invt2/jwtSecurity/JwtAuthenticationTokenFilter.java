/******************************************************************************
 * Copyright (c) 2017-2018. Spring-Boot -Version 2.1.0.RELEASE                *
 * JwtAuthenticationTokenFilter.java  181209 01:51:27 by @Chenccsy            *
 * JavaProject builded by IDE@ ,all rights reserved.                          *
 ******************************************************************************/

package cc.test.invt2.jwtSecurity;

import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT 过滤器
 */

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

  private final Log logger = LogFactory.getLog(this.getClass());


  private UserDetailsService userDetailsService;

  private JwtTokenUtil jwtTokenUtil;


  private String tokenHeader;

  private String tokenHead;

  public JwtAuthenticationTokenFilter(UserDetailsService userDetailsService, JwtTokenUtil jwtTokenUtil, String tokenHeader,String tokenHead) {
    this.userDetailsService = userDetailsService;
    this.jwtTokenUtil = jwtTokenUtil;
    this.tokenHeader = tokenHeader;
    this.tokenHead = tokenHead;
  }

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
    final String requestHeader = request.getHeader(this.tokenHeader);

    System.out.println(requestHeader);
    System.out.println("tokenHeader:"+tokenHeader);
    System.out.println("this.tokenHead:"+this.tokenHead);
    String username = null;
    String authToken = null;
    if (requestHeader != null && requestHeader.startsWith(this.tokenHead)) {
      authToken = requestHeader.substring(7);
      try {
        username = jwtTokenUtil.getUsernameFromToken(authToken);
      } catch (IllegalArgumentException e) {
        logger.error("an error occured during getting username from token", e);
      } catch (ExpiredJwtException e) {
        logger.warn("the token is expired and not valid anymore", e);
      }
    } else {
      logger.warn("couldn't find "+this.tokenHead+" string, will ignore the header");
    }

    logger.info("checking authentication for user " + username);
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

      // It is not compelling necessary to load the use details from the database. You could also store the information
      // in the token and read it from it. It's up to you ;)
      UserDetails userDetails = this.userDetailsService.loadUserByUsername(username);

      // For simple validation it is completely sufficient to just check the token integrity. You don't have to call
      // the database compellingly. Again it's up to you ;)
      if (jwtTokenUtil.validateToken(authToken, userDetails)) {
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        logger.info("authenticated user " + username + ", setting jwtSecurity context");
        SecurityContextHolder.getContext().setAuthentication(authentication);
      }
    }
    chain.doFilter(request, response);
  }
}