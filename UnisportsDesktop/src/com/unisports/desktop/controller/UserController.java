package com.unisports.desktop.controller;

import com.unisports.bl.UserBL;
import com.unisports.desktop.model.UserViewModel;
import com.unisports.desktop.view.LoginView;
import com.unisports.entities.User;
import javax.swing.JOptionPane;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;


public class UserController {
    UserBL _userBL;
    Mapper _mapper;
    LoginView loginView;

    public UserController(){
        _userBL = new UserBL();
        _mapper = new DozerBeanMapper();
    }
    
    public void editProfile(UserViewModel model) {
        
        //Adapter
        User destObject = _mapper.map(model, User.class);
        
        boolean result = _userBL.editUser(destObject);
        
        JOptionPane.showMessageDialog(this.loginView, result ? "Guardado!" : "Error al guardar.");
    }
    
}
