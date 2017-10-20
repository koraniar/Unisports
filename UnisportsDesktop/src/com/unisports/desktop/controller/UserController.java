package com.unisports.desktop.controller;

import com.unisports.bl.UserBL;
import com.unisports.desktop.model.UserViewModel;
import com.unisports.entities.User;
import javax.swing.JOptionPane;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;


public class UserController {
    UserBL _userBL;
    Mapper _mapper;

    public UserController(){
        _userBL = new UserBL();
        _mapper = new DozerBeanMapper();
    }
    
}
