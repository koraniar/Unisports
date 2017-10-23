package com.unisports.rest;

import com.unisports.entities.Sport;
import com.unisports.enums.SportType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    

    @RequestMapping("/greeting")
    public Sport greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
        Sport sp = new Sport();
        sp.setName(name);
        sp.setType(SportType.Futbol);
        
        return sp;
        
    }
    
}
