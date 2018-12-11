/******************************************************************************
 * Copyright (c) 2017-2018. Spring-Boot -Version 2.1.0.RELEASE                *
 * JwtAuthenticationResponse.java  181209 01:51:26 by @Chenccsy               *
 * JavaProject builded by IDE@ ,all rights reserved.                          *
 ******************************************************************************/

package cc.test.invt2.jwtSecurity.domain;

import java.io.Serializable;


public class JwtAuthenticationResponse implements Serializable {
  private static final long serialVersionUID = 4784951536404964122L;
  private final String token;

  public JwtAuthenticationResponse(String token) {
    this.token = token;
  }

  public String getToken() {
    return this.token;
  }
}
