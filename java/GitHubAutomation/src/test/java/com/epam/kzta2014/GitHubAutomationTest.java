package com.epam.kzta2014;

import com.epam.kzta2014.steps.Steps;
import com.epam.ta.reportportal.listeners.testng.ReportPortalTestNGListener;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ReportPortalTestNGListener.class})
public class GitHubAutomationTest {
    private Steps steps;
    private final String USERNAME = "testautomationuser";
    private final String PASSWORD = "password";

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void oneCanCreateProject() {
        steps.loginGithub(USERNAME, PASSWORD);
        Assert.assertTrue(steps.createNewRepository("testRepo", "auto-generated test repo"));
        Assert.assertTrue(steps.currentRepositoryIsEmpty());

        // do not use lots of asserts
    }

    @Test(description = "Login to Github")
    public void oneCanLoginGithub() {
        steps.loginGithub(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @AfterMethod(description = "Stop Browser")
    public void stopBrowser() {
        steps.closeDriver();
    }

}
