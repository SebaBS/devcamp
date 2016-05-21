package com.finder.controller;

import com.finder.service.FindService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by adam on 21.05.16.
 */

@RestController
public class FindController {

    FindService findService = new FindService();

    @RequestMapping(value="find", method = {RequestMethod.POST}, params="value")
    public String index (String value)
    {
        try{
            return findService.gatherInformations(value);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

}
