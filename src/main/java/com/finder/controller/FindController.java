package com.finder.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adam on 21.05.16.
 */

@RestController
public class FindController {

    @RequestMapping("/")
    public String index(){
        return "Find what you want:";
    }
}
