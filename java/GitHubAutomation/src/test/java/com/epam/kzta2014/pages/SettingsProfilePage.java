package com.epam.kzta2014.pages;

import com.epam.kzta2014.utils.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Tatyana_Korobitsina on 3/20/2015.
 */
public class SettingsProfilePage extends AbstractPage

{
    private final Logger logger = Logger.getLogger(SettingsProfilePage.class);
    private final String BASE_URL = "https://github.com/settings/profile";

    @FindBy(id = "upload-profile-picture")
    private WebElement profilePicture;

    @FindBy(xpath = "//input[@id='user_profile_name']")
    private WebElement inputName;

    @FindBy(xpath = "//select[@id='user_profile_email']")
    private WebElement showEmail;

    @FindBy(xpath = "//p[@class='note']//a")
    private WebElement linkEmailSetting;

    @FindBy(id = "user_profile_blog")
    private WebElement inputProfileLink;

    @FindBy(id = "user_profile_company")
    private WebElement inputCountry;

    @FindBy(id = "user_profile_location")
    private WebElement inputLocation;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonUpdateProfile;

    @FindBy(className = "flash-notice")
    private WebElement linkGoodUpdate;

    @FindBy(xpath = "//a[text()='Join the GitHub Developer Program']")
    private WebElement linkJoinDevelopProgram;

    @FindBy(xpath = "//a[text()='Developer site']")
    private WebElement linkDevelopSite;

    @FindBy(xpath = "//input[@name = 'user[profile_hireable]'][@value=1]")
    private WebElement checkboxAvailableForHire;

    @FindBy(xpath = "//button[text()='Save jobs profile']")
    private WebElement buttonSAveJobProfile;


    public SettingsProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Profile page opened");
    }

    public String updateSettingProfile() {
        buttonUpdateProfile.click();
        logger.info("Profile updated");
       return  linkGoodUpdate.getText();
    }


    public String getInputName(String name) {
        String profileName = name + Utils.getRandomString(6);
        inputName.clear();
        inputName.sendKeys(profileName);
        buttonUpdateProfile.click();
        return profileName;
    }

    public String getProfileName() {
        return inputName.getAttribute("value");
    }


 //   public String getLinkEmailSettingText() {
    //   return linkEmailSetting.getText();
    //}

}