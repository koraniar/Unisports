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
public enum RelationshipState {
    WaitingFor(0),
    Accepted(1),
    Denied(2);
    
    private int itemVal;
    
    RelationshipState(int val){
        this.itemVal = val;
    }
    
    public int getHashCode(){
        return this.itemVal;
    }
}
