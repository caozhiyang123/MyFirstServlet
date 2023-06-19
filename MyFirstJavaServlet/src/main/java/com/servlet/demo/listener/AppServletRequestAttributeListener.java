package com.servlet.demo.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class AppServletRequestAttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        System.out.println("ServletRequestAttributeEvent attributeAdded triggered,"+event.getName()+":"+event.getValue());
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        System.out.println("ServletRequestAttributeEvent attributeRemoved triggered,"+event.getName()+":"+event.getValue());
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        System.out.println("ServletRequestAttributeEvent attributeReplaced triggered,"+event.getName()+":"+event.getValue());
        //ServletRequestAttributeEvent attributeReplaced triggered,org.apache.catalina.ASYNC_SUPPORTED:true
    }
}
