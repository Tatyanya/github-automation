package com.epam.kzta2014;

import com.epam.kzta2014.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Tatyana_Korobitsina on 3/22/2015.
 */
public class TestTest {

    private Steps steps;

    @BeforeTest
    public void globalSetUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @AfterTest
    public void globalTearDown() {
        steps.closeDriver();
    }

    @Test
    public void testOne() {
        steps.loginGithub("tatyanya", "Aaa159263");
        Assert.assertEquals("tatyana", steps.getUserProfileName());
    }

}
