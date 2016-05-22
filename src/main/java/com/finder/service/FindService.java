package com.finder.service;

import com.finder.model.Storage;
import org.apache.commons.io.IOUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


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
        HashMap<String, String> processed = new HashMap<>();
        processed.put("value", value);
        storage.save(processed);
    }

    public List<Element> gatherFromGoogle(String value) throws Exception{
        List<Element> results = new ArrayList<>();
        String google = "http://www.google.com/search?q=";
        String charset = "UTF-8";
        String userAgent = "ExampleBot 1.0 (+http://example.com/bot)";

        Elements links = Jsoup.connect(google + URLEncoder.encode(value, charset)).userAgent(userAgent).get().select(".g>.r>a");
        for (Element link: links){
            String title = link.text();
            String url = link.absUrl("href");
            url = URLDecoder.decode(url.substring(url.indexOf('=') + 1, url.indexOf('&')), "UTF-8");
            if (!url.startsWith("http")) {
                continue; // Ads/news/etc.
            }
            results.add(link);
        }
        return results;
    }
}
