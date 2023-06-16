package com.servlet.demo.service;

import com.servlet.demo.dao.UserDAO;
import com.servlet.demo.manager.DBConnectionManager;
import com.servlet.demo.vo.UserVO;

import java.sql.Connection;

public class LoginService {
    private UserDAO userDAO = null;

    public LoginService() {
        userDAO = new UserDAO();
    }

    public UserVO login(String name, DBConnectionManager dbManager) {
        return userDAO.findUser(name,dbManager);
    }
}
