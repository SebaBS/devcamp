package com.finder.service;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by adam on 21.05.16.
 */


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


}
