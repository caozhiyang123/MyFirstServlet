package com.servlet.demo.listener;

import com.servlet.demo.manager.DBConnectionManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AppServletContextListener implements ServletContextListener {
    private ServletContext context = null;

    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
            context = event.getServletContext();
            String dbDriver = context.getInitParameter("DBDRIVER");
            String dbUrl = context.getInitParameter("DBURL");
            String dbUser = context.getInitParameter("DBUSER");
            String dbPass = context.getInitParameter("DBPASS");

            DBConnectionManager manager = new DBConnectionManager(dbDriver,dbUrl, dbUser, dbPass);
            context.setAttribute("DBManager",manager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        context = event.getServletContext();
        //DBConnectionManager dbManager = (DBConnectionManager)context.getAttribute("DBManager");
        context.removeAttribute("DBManager");
    }
}
