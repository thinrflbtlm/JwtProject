/******************************************************************************
 * Copyright (c) 2017-2018. Spring-Boot -Version 2.1.0.RELEASE                *
 * Authority.java  181209 03:18:39 by @Chenccsy                               *
 * JavaProject builded by IDE@ ,all rights reserved.                          *
 ******************************************************************************/

package cc.test.invt2.domain;

import java.io.Serializable;

public class Authority implements Serializable {
    private int id;
    private AuthorityName name;
    private String descr;


    public Authority(int id, AuthorityName name, String descr) {
        this.id = id;
        this.name = name;
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", name=" + name +
                ", descr='" + descr + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AuthorityName getName() {
        return name;
    }

    public void setName(AuthorityName name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
}
