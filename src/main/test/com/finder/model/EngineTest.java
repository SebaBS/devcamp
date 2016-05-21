package com.finder.model;

import com.finder.model.Enum.Web;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by adam on 21.05.16.
 */

public class EngineTest {

    private Engine engine;

    @Before
    public void init(){
        engine = new Engine();
    }

    @Test
    public void testReplaceSpaces(){
        String actual = engine.replaceSpaces("tekst ze spacja", Engine.PLUS);
        String expected = "tekst+ze+spacja";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCreatePath(){
        String actualGoogle = engine.createPath(Web.GOOGLE, "adam masnik");
        String expectedGoogle = "https://www.google.pl/#q=adam+masnik";
        Assert.assertEquals(expectedGoogle, actualGoogle);

        String actualGolden = engine.createPath(Web.GOLDENLINE, "adam masnik");
        String expectedGolden = "https://www.goldenline.pl/adam-masnik/";
        Assert.assertEquals(expectedGolden, actualGolden);

    }
}
