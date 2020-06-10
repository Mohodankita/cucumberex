package stepDefinations;

import java.util.Properties;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import util.Global;

@RunWith(Cucumber.class)

public class stepDefination {
	private Global global;
	private WebDriver driver;

	private Properties Pro;
	

	@Given("^User is on login page$")
	public void user_is_on_login_page() throws Throwable {
		System.out.println("User is on login page");
		global = new Global();
		driver = global.driver();
		// Write code here that turns the phrase above into concrete actions

		Pro = global.readPropertyFile();
	}

	@When("^User login into application with username \"([^\"]*)\"$")
	public void user_login_into_application_with_username(String arg1) throws Throwable {

		System.out.println("login into application with username");
		driver.findElement(By.id("email")).sendKeys(arg1);
		
		
		System.out.println(arg1);
		
	}
	@When("^User login into application with password \"([^\"]*)\"$")
	public void user_login_into_application_with_password(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("login into application with password");
		driver.findElement(By.id("password")).sendKeys(arg1);
		driver.findElement(By.className("btn btn-primary btn-block btn-flat")).click();
		System.out.println(arg1);
		driver.close();
	}
	

}
