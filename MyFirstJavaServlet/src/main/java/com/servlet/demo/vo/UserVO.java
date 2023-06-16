package com.servlet.demo.vo;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

public class UserVO implements HttpSessionActivationListener, Serializable {
    private String name;
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("UserVO will passivate,session id:"+se.getSession().getId());
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("UserVO did activate,session id:"+se.getSession().getId());
    }
}
