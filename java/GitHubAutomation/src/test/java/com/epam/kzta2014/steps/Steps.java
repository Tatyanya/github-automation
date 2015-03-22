package com.epam.kzta2014.steps;

import com.epam.kzta2014.pages.CreateNewRepositoryPage;
import com.epam.kzta2014.pages.LoginPage;
import com.epam.kzta2014.pages.MainPage;
import com.epam.kzta2014.pages.SettingsProfilePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

public class Steps {

    private static final Logger LOGGER = Logger.getLogger(Steps.class);

    private WebDriver driver;

    public void initBrowser() {
        driver = new FirefoxDriver();
        //driver = new HtmlUnitDriver();
        System.setProperty("webdriver.chrome.driver", "c:\\soft\\chromedriver.exe");
        //driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOGGER.info("Browser started");
    }

    public void closeDriver() {
        driver.quit();
    }

    public void loginGithub(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username) {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username));
    }

    public boolean createNewRepository(String repositoryName, String repositoryDescription) {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnCreateNewRepositoryButton();
        CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
        String expectedRepoName = createNewRepositoryPage.createNewRepository(repositoryName, repositoryDescription);
        return expectedRepoName.equals(createNewRepositoryPage.getCurrentRepositoryName());
    }

    public boolean currentRepositoryIsEmpty() {
        CreateNewRepositoryPage createNewRepositoryPage = new CreateNewRepositoryPage(driver);
        return createNewRepositoryPage.isCurrentRepositoryEmpty();
    }

    public String getUserProfileName() {
        SettingsProfilePage profilePage = new SettingsProfilePage(driver);
        profilePage.openPage();
        return profilePage.getInputName();
    }

    public String getLinkEmailSettingText() {
        SettingsProfilePage settingsProfilePage = new SettingsProfilePage(driver);
        settingsProfilePage.openPage();
        return settingsProfilePage.getLinkEmailSettingText();
    }

}
