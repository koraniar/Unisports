/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.enums;

/**
 *
 * @author koraniar
 */
public enum SportType {
    Futbol(0),Basquetball(1);
    
    private int itemVal;
    
    SportType(int val){
        this.itemVal = val;
    }
    
    public int getHashCode(){
        return this.itemVal;
    }
}
