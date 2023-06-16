package com.servlet.demo.dao;

import com.servlet.demo.manager.DBConnectionManager;
import com.servlet.demo.vo.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
    public UserVO findUser(String name, DBConnectionManager dbManager) {
        UserVO userVO = null;
        Connection con = null;
        PreparedStatement pst = null;
        ResultSet rst = null;

        try {
            String sql = String.format("select * from users where `name` = ?");
            con = dbManager.getConnection();
            pst = con.prepareStatement(sql);
            pst.setString(1,name);
            rst = pst.executeQuery();

            while (rst.next()){
                userVO = new UserVO();
                userVO.setName(name);
                userVO.setId(rst.getLong("id"));
                break;
            }
            return userVO;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbManager.closeConnection(rst,pst,con);
        }
        return userVO;
    }
}
