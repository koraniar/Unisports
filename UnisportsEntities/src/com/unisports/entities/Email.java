package com.unisports.entities;

import java.util.List;
import java.util.UUID;


public class Email {
    private UUID id;
    private String body;
    private List<EmailAttachment> attachmentList;
    
    public Email(){
        this.id = UUID.randomUUID();
    }
    
    public UUID getID(){
        return this.id;
    }
    
    public void setBody(String body){
        this.body = body;
    }
    
    public String getBody(){
        return this.body;
    }
    
    public void addItemtoAttachmentList(EmailAttachment attachment){
        this.attachmentList.add(attachment);
    }
    
    public void deleteItemFromAttachmentList(EmailAttachment attachment){
        this.attachmentList.remove(attachment);
    }
    
    public List<EmailAttachment> getAttachmentList(){
        return this.attachmentList;
    }
}