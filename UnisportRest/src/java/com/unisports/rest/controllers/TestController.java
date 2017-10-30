package com.unisports.rest.controllers;


import com.unisports.entities.Sport;
import com.unisports.enums.SportType;
import java.util.concurrent.atomic.AtomicLong;
import javax.ws.rs.Path;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    //@Path("/users")
    @RequestMapping("/greeting")
    public Sport greeting(@RequestParam(value="name", defaultValue="World") String name) {
        
        Sport sp = new Sport();
        sp.setName(name);
        sp.setType(SportType.Futbol);
        
        return sp;
    }
}
