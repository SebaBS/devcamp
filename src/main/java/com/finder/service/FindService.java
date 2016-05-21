package com.finder.service;

import com.finder.model.Storage;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;


public class FindService {

    public String gatherInformations(String link) throws Exception{
        URL url = new URL(link);
        URLConnection conn = url.openConnection();
        InputStream inputStream = conn.getInputStream();
        String encoding = conn.getContentEncoding();
        encoding = encoding == null? "UTF-8" : encoding;
        String body = IOUtils.toString(inputStream, encoding);
        System.out.println(body);
        return body;
    }


    public void lookFor(String value, Storage storage)
    {
        HashMap<String, String> processed = new HashMap<String, String>();
        processed.put("value", value);
        storage.save(processed);
    }
}
