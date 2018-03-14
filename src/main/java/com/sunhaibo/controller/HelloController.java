package com.sunhaibo.controller;

import com.sunhaibo.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/fuck")
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = "/say", method = RequestMethod.GET)
    @GetMapping(value = "cao")
    public String say(@RequestParam(value = "name",required = false,defaultValue = "111") String myname) {
//        return girlProperties.getCupSize();
//        return "index";
    return "name:"+myname;
    }
}
