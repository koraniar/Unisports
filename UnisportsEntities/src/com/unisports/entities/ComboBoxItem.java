package com.unisports.entities;

import java.util.UUID;

public class ComboBoxItem {

    private UUID id;
    private String label;
    private String altId;
    
    public ComboBoxItem(UUID id, String label){
        this.id = id;
        this.label = label;
    }
    
    public ComboBoxItem(String altId, String label){
        this.altId = altId;
        this.label = label;
    }
    
    public ComboBoxItem(UUID id, String altId, String label){
        this.id = id;
        this.altId = altId;
        this.label = label;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }

    public void setAltId(String altId) {
        this.altId = altId;
    }

    public String getAltId() {
        return this.altId;
    }
    
    @Override
    public String toString(){
        return this.label;
    }
}
