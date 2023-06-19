package com.servlet.demo.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

public class AppServletRequestListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("ServletRequestEvent requestInitialized triggered"+sre.getServletRequest().getRemoteAddr());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("ServletRequestEvent requestDestroyed triggered"+sre.getServletRequest().getRemoteAddr());
    }
}
