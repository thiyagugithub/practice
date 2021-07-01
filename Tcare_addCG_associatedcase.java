package testcases_testing;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import common_things.Before_After_Login;

public class Tcare_addCG_associatedcase extends Before_After_Login {

	@Test(priority = 1)
	public void Tcare_uat_Login() throws InterruptedException {

		WebElement username1 = driver.findElement(By.id("email"));
		username1.clear();
		username1.sendKeys("thiyagus");

		WebElement password1 = driver.findElement(By.id("password"));
		password1.clear();
		password1.sendKeys("Thiyagu@123");
		
		try {
			WebElement click_login_btn = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
			click_login_btn.click();
			WebDriverWait wait = new WebDriverWait(driver, 50);
		    wait.until(ExpectedConditions.alertIsPresent());
			Alert alert111 = driver.switchTo().alert();
			alert111.accept();
			System.out.println("Login Alert accepted");
			Thread.sleep(1000);
			WebElement click_user1 = driver.findElement(By.xpath("/html/body/app-root/div[1]"));
			click_user1.click();
			System.out.println(click_user1.getText());
		} 	catch (Exception e) {
			e.printStackTrace();
		}
		
          Thread.sleep(20000);
		
		if(driver.findElement(By.xpath("//h3[contains(text(),'DASHBOARD')]")).isDisplayed()) {
			System.out.println("Valid Username/Password Login Validation Success: ");	
		}else {
			System.out.println("Valid Username/Password Login Validation Failed");	
		}
		Thread.sleep(5000);
	
}

	@Test(priority = 2)
	public void Associated_case_CG() throws InterruptedException {
		Thread.sleep(10000);
	
		WebElement Click_caselist = driver.findElement(By.xpath("//i[@class='fas fa-suitcase']"));
		Click_caselist.click();
		Thread.sleep(20000);
			
		WebElement search_id = driver.findElement(By.xpath("(//input[@data-placeholder='Search'])[1]"));
		search_id.click();
		search_id.clear();
		search_id.sendKeys("3662");
		Thread.sleep(10000);
			
		WebElement caseid = driver.findElement(By.xpath("//a[contains(text(),'3662')]"));	
		caseid.click();	
		Thread.sleep(10000);
		
		WebElement Associatedcase = driver.findElement(By.xpath("//a[@title='Caregiver Associated Cases']"));
		Associatedcase.click();	
					
		WebElement add_caregiver = driver.findElement(By.xpath("(//div[@title='click to add care recieverss'])[2]"));
		JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		executor1.executeScript("arguments[0].scrollIntoView(true);", add_caregiver);   
		add_caregiver.click();
			
		WebElement CGfirstname = driver.findElement(By.id("cgfirstName"));
		CGfirstname.clear();
		CGfirstname.sendKeys("30june06");
		
		WebElement CGlasttname = driver.findElement(By.id("cglastName"));
		CGlasttname.clear();
		CGlasttname.sendKeys("testCG");
		
		WebElement relation = driver.findElement(By.id("cgrelationship"));
		Select select = new Select(relation);
		select.selectByVisibleText("Daughter");
		
			
		WebElement submit = driver.findElement(By.xpath("(//button[contains(text(),'Submit')])[1]"));
		submit.click();
			
		Thread.sleep(10000);
		
		WebElement Dashboard = driver.findElement(By.xpath("//i[@class='fas fa-tachometer-alt']"));
		Dashboard.click();
		
		Thread.sleep(10000);

		WebElement Click_assessmentlist = driver.findElement(By.xpath("//i[@class='far fa-edit']"));
		Click_assessmentlist.click();
		Thread.sleep(10000);
			
		WebElement assessmentsearch_name = driver.findElement(By.xpath("//input[@data-placeholder='Search']"));
		assessmentsearch_name.click();
		assessmentsearch_name.clear();
		assessmentsearch_name.sendKeys("30june06");
		Thread.sleep(10000);
	      
		WebElement Cgcaseid = driver.findElement(By.xpath("//div[1]/div/div/mat-table/mat-row/mat-cell[1]/a"));
		Cgcaseid.click();
		Thread.sleep(10000);
		
		WebElement Cgcaseid1 = driver.findElement(By.xpath("//div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]"));
		Thread.sleep(10000);
		String p = Cgcaseid1.getText();
		System.out.println("CG Case ID is:  "+ p);
		
		if(driver.findElement(By.xpath("//a[contains(text(),' 30june06')]")).isDisplayed()){
		System.out.println("successfully captured CG case ID");
		
		}else {
		System.out.println("captured CG case ID Failed");
		}
	}
	
//	@Test(priority = 4)
	public void logout() throws InterruptedException {
		Thread.sleep(5000);
// 		Thread.sleep(10000);
		
		WebElement relogin1=driver.findElement(By.xpath("//span[@data-toggle='modal']"));
		relogin1.click();
		Thread.sleep(5000);
		
		WebElement logout11=driver.findElement(By.xpath("//div[contains(text(),'Logout')]"));
	    logout11.click();
	    
	    Thread.sleep(5000);
		
	    WebElement login_pg = driver.findElement(By.id("email"));
		login_pg.click();
		if (login_pg.isDisplayed()) {
			System.out.println("Logout Validation Success");
		}
		else {
			System.out.println("Logout Validation Failed");
		}
		
		
		
	}
	
}
