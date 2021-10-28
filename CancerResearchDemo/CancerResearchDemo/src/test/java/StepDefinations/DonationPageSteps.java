package StepDefinations;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DonationPageSteps {

	public static WebDriver driver;
	String ExpectedTitle = "Single Donation | Cancer Research UK";
	String ActualTitle = "";
	String BaseUrl = "https://app.pws.int.cruk.org/support-us/your-donation";
	WebElement AmountValue10;
	public static WebDriverWait wait;

	@Given("Cancer research single donation page is opened in chrome browser")
	public void cancer_research_single_donation_page_is_opened_in_chrome_browser() {
		String Demopath = System.getProperty("user.dir");
		System.out.println("Project path is : " + Demopath);
		System.setProperty("webdriver.chrome.driver",
				Demopath + "/src/test/resources/drivers/Windows/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(BaseUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}

//	@And("Cookies policy is accepted by clicking on OK continue to Site button")
//	public void cookies_policy_is_accepted_by_clicking_on_ok_continue_to_site_button() {
//		WebElement Cookiespolicy = driver.findElement(By.id("onetrust-accept-btn-handler"));
//		if (Cookiespolicy.isDisplayed()) {
//			System.out.println("Cookies Policy is Displayed");
//			driver.findElement(By.id("onetrust-accept-btn-handler")).click();
//		}	
//		System.out.println("cookies policy not displayed");
//	}

	@When("page title is validated")
	public void page_title_is_validated() {
		ActualTitle = driver.getTitle();
		if (ActualTitle.equals(ExpectedTitle)) {
			System.out.println("User is on the cancer Research Donation page");
		}

		else {
			System.out.println("User is Not in the cancer Research Donation page");
		}
	}

	@And("user see the Amounts and selects Amount Ten")
	public void user_see_the_amounts_and_selects_ten() {
		AmountValue10 = driver.findElement(By.id("amount10"));
		if (!AmountValue10.isDisplayed()) {
			System.out.println("Amount value is not Displayed");
	//		cookies_policy_is_accepted_by_clicking_on_ok_continue_to_site_button();
		}
		AmountValue10.click();
		System.out.println("Amount value 10 is Clicked");
	}

	@Then("validate if the amount is selected")
	public void validate_if_the_amount_is_selected() {
		AmountValue10 = driver.findElement(By.id("amount10"));
		String str = AmountValue10.getAttribute("checked");
		if (str.equalsIgnoreCase("true")) {
			System.out.println("Amount 10 is  selected");
		}
	}

	@And("user see textbox to enter an amount and Enter Negative value")
	public void user_see_textbox_to_enter_an_amount_and_enter_negative_value() throws InterruptedException {
		WebElement otherAmttxt = driver.findElement(By.id("otherAmount"));
		otherAmttxt.sendKeys("-100");
		
	}

	@Then("user receive a error message")
	public void user_receive_a_error_message() {
		WebElement otherAmtError = driver.findElement(By.id("otherAmount-error"));
			String expectedErrorMsg = "Please enter an amount using numbers and a decimal point only.";
		if (otherAmtError.getText().equals(expectedErrorMsg)) {
			System.out.println("Error message matched | Test Passed");

		} else {
			System.out.println("Error message matched | Test Failed");

		}
	}

	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
		driver.quit();
	}

}
