package com.servlet.demo.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AppHttpSessionAttributeListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("name:"+event.getName()+",value:"+event.getValue()+",session attribute added");
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        System.out.println("name:"+event.getName()+",value:"+event.getValue()+",session attribute removed");
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("name:"+event.getName()+",value:"+event.getValue()+",session attribute replaced");
    }
}
