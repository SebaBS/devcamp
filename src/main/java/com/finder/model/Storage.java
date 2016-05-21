package com.finder.model;

import java.util.HashMap;
import java.util.TreeMap;

public class Storage
{
    TreeMap<Long, HashMap<String, String>> container = null;

    public Storage()
    {
        this.container = new TreeMap<Long, HashMap<String, String>>();
    }

    public void save(HashMap<String, String> record)
    {
        this.container.put(System.currentTimeMillis(), record);
    }
}
