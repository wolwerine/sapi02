package ro.sapientia.mesteri2015.test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SCRUMSprintCommentStepDefinition {

	protected WebDriver driver;

	@Before
	public void setup() {
		driver = new FirefoxDriver();
	}

	@Given("^Given I add a comment to the scrum list's first story$")
	public void I_add_a_comment_to_the_scrum_list_s_first_story() throws Throwable {
	    // Express the Regexp above with the code you wish you had
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://localhost:8080/");
	}

	@When("^I enter \"([^\"]*)\" in  the title textbox and I push the add button$")
	public void I_enter_in_the_title_textbox_and_I_push_the_add_button(String updateTitle) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		WebElement addButton = driver.findElement(By.id("story-1"));
		addButton.click();
		//driver.wait(1000);
		WebElement updateButton = driver.findElement(By.id("action-addcomment-button"));
		updateButton.click();
		WebElement comment = driver.findElement(By.id("comment-1"));
		comment.click();
		//driver.wait(1000);
		WebElement titleField = driver.findElement(By.id("comment-title"));
		titleField.sendKeys(Keys.CONTROL + "a");
		titleField.sendKeys(Keys.DELETE);
		titleField.sendKeys(updateTitle);
		
		WebElement updateStoryButton = driver.findElement(By.id("update-comment-button"));
		updateStoryButton.click();
	
	}
	
	@Then("^I should get result \"([^\"]*)\" in comment list$")
	public void I_should_get_result_in_new_comment_list(String expectedResult) throws Throwable {
	    // Express the Regexp above with the code you wish you had
		WebElement titleText = driver.findElement(By.id("comment-title"));
		String result = titleText.getText();

		// Verify that result of 2+2 is 4
		Assert.assertEquals(result, expectedResult);
		//Assert.assertNotSame(result, expectedResult);
		driver.close();
	}
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
