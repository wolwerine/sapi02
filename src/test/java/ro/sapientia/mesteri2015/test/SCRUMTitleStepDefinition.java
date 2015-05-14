package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMTitleStepDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^I open the scrum tool$")
	public void I_open_google() {
		// Set implicit wait of 10 seconds and launch google
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}
	
	@When("^I enter \"([^\"]*)\" in  the title textbox$")
	public void I_enter_in_the_title_textbox(String additionTerms) throws Throwable {
		// Click on searchButton
		WebElement addButton = driver.findElement(By.id("add-button"));
		addButton.click();

		// Write term in google textbox
		WebElement titleTextBox = driver.findElement(By.id("story-title"));
		titleTextBox.sendKeys(additionTerms);

		// Click on searchButton
		WebElement searchButton = driver.findElement(By.id("add-story-button"));
		searchButton.click();
	}


	@Then("^I should get result \"([^\"]*)\"$")
	public void I_should_get_correct_result(String expectedResult) {

		WebElement calculatorTextBox = driver.findElement(By.id("story-title"));
		String result = calculatorTextBox.getText();

		// Verify that result of 2+2 is 4
		Assert.assertEquals(result, expectedResult);

		driver.close();
	}

	@After
	public void closeBrowser() {
		driver.quit();
	}

}
