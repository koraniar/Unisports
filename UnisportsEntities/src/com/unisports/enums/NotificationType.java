/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.enums;

/**
 *
 * @author danielmontana
 */
public enum NotificationType {
    
    Created(0),
    Readed(1);
    
    private int itemVal;
    
    NotificationType(int val){
        this.itemVal = val;
    }
    
    public int getHashCode(){
        return this.itemVal;
    }
    
}
