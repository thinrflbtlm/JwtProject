/******************************************************************************
 * Copyright (c) 2017-2018. Spring-Boot -Version 2.1.0.RELEASE                *
 * AuthenticationRestController.java  181209 01:51:27 by @Chenccsy            *
 * JavaProject builded by IDE@ ,all rights reserved.                          *
 ******************************************************************************/

package cc.test.invt2.jwtSecurity.controller;

import cc.test.invt2.jwtSecurity.JwtTokenUtil;
import cc.test.invt2.jwtSecurity.domain.JwtAuthenticationRequest;
import cc.test.invt2.jwtSecurity.domain.JwtAuthenticationResponse;
import cc.test.invt2.jwtSecurity.domain.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * 授权控制器
 *
 *
 */
@RestController
@RequestMapping("/api")
public class AuthenticationRestController {

  @Value("${jwt.header}")
  private String tokenHeader;



  @Autowired
  private AuthenticationManager authenticationManager;


  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @Autowired
//  按定义的serviceid来绑定
  @Qualifier("jwtUserDetailsService")
  private UserDetailsService userDetailsService;

  /**
   * 创建授权令牌 (登录)
   *
   * @param authenticationRequest
   * @return
   * @throws AuthenticationException
   */
  @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
  public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException {


    authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
    System.out.println(authenticationRequest.getPassword()+"\n"+authenticationRequest.getUsername());
    // Reload password post-jwtSecurity so we can generate the token
    final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//    final JwtUser  jwtUser =(JwtUser) userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//    System.out.println(userDetails);
    final String token = jwtTokenUtil.generateToken(userDetails);
//    System.out.println(token);
    // Return the token
//    return ResponseEntity.ok(new JwtAuthenticationResponse(jwtUser.toString()));
    return ResponseEntity.ok(new JwtAuthenticationResponse(token));
  }

  /**
   * 刷新
   *
   * @param request
   * @return
   */
  @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
  public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
    String authToken = request.getHeader(tokenHeader);
    final String token = authToken.substring(7);
    String username = jwtTokenUtil.getUsernameFromToken(token);
    JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

    if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
      String refreshedToken = jwtTokenUtil.refreshToken(token);
      return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
    } else {
      return ResponseEntity.badRequest().body(null);
    }
  }

  @ExceptionHandler({AuthenticationException.class})
  public ResponseEntity<String> handleAuthenticationException(AuthenticationException e) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
  }

  /**
   * Authenticates the user. If something is wrong, an {@link AuthenticationException} will be thrown
   */
  private void authenticate(String username, String password) {
    Objects.requireNonNull(username);
    Objects.requireNonNull(password);

    try {
      authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));


    } catch (DisabledException e) {
      throw new AuthenticationException("User is disabled!", e);
    } catch (BadCredentialsException e) {
      throw new AuthenticationException("Bad credentials!", e);
    }
  }

}
