/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unisports.enums;

/**
 *
 * @author ESTUDIANTE1220T
 */
public enum EventState {
    Created(0),
    Canceled(1);
    
    private int itemVal;
    
    EventState(int val){
        this.itemVal = val;
    }
    
    public int getHashCode(){
        return this.itemVal;
    }
}
