package com.finder.controller;

import com.finder.model.Engine;
import com.finder.model.Enum.Web;
import com.finder.model.Storage;
import com.finder.service.FindService;
import org.jsoup.nodes.Element;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 21.05.16.
 */

@RestController
public class FindController {

    private FindService findService = new FindService();

    @RequestMapping(value="find", method = RequestMethod.POST, params="value")
    public String index (String value)
    {
        Storage storage = new Storage();
        try {
            findService.lookFor(value, storage);
            String body = findService.gatherInformations(value);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "";
    }

    @RequestMapping(value = "build", method = RequestMethod.GET, params = "value")
    public List<Element> getPath(String value){
        Engine engine = new Engine();
        engine.createPath(Web.GOOGLE, value);
        engine.createPath(Web.GOLDENLINE, value);
        List<Element> list = new ArrayList<>();
        try{
            list = findService.gatherFromGoogle(value);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


}
