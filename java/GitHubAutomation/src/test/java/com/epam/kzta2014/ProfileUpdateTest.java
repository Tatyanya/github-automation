package com.epam.kzta2014;

import com.epam.kzta2014.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Tatyana_Korobitsina on 3/22/2015.
 */
public class ProfileUpdateTest {

    private Steps steps;
    private final String USERNAME = "tatyanya";
    private final String PASSWORD = "Aaa159263";

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
    public void checkUpdateProfileMessage() {
        steps.loginGithub(USERNAME, PASSWORD);
        Assert.assertEquals(steps.getUpdateProfile(), "Profile updated successfully");
    }

    // @Test
    //public void testGetLinkEmailSettingText() {
        //steps.loginGithub("tatyanya", "Aaa159263");
      //  Assert.assertEquals(steps.getLinkEmailSettingText(), "personal email settings");
    //}

}