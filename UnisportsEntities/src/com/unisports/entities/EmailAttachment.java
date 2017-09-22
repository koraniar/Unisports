package com.unisports.entities;


public class EmailAttachment {
    private byte[] content;
    private String contentName;
    
    public void setContent(byte[] content){
        this.content = content;
    }
    
    public byte[] getContent(){
        return this.content;
    }
    
    public void setContentName(String name){
        this.contentName = name;
    }
    
    public String getContentName(){
        return this.contentName;
    }
}
