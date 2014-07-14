package com.epam.kzta2014.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
	private final String BASE_URL = "https://github.com/";
	private final WebDriver driver;

	@FindBy(xpath = "//a[@aria-label='Create new...']")
	private WebElement buttonCreateNew;

	@FindBy(className = "octicon-repo")
	private WebElement linkNewRepository;

	public MainPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	public void clickOnCreateNewRepositoryButton()
	{
		buttonCreateNew.click();
		linkNewRepository.click();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		System.out.println("Main Page opened");
	}
}