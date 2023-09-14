package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.Scanner;


import Base.BaseClass;

public class classPageElements extends BaseClass
{
	public classPageElements()
	{
		PageFactory.initElements(driver, this);
	}
	
	public By loginField = By.xpath("//logintextfiled");
	public By passwordField = By.xpath("//passwordfield");
	public By loginButton = By.xpath("//loginbutton");
	public By classButton = By.xpath("//classbutton in navigation bar");
	public By deleteButton = By.xpath("//Deletebutton");
	public By editButton = By.xpath("//Editbutton");
	public By searchBar = By.xpath("//searchbar");
	public By addNewClassButton = By.xpath("//addnewclassButton");
	public By dataTable = By.xpath("//table");
	public List<WebElement> editIcon = driver.findElements(By.xpath("//*[@id='edit-icon']"));;
	public List<WebElement> deleteIcon = driver.findElements(By.xpath("//*[@id='delete-icon']"));
	public List<WebElement> sortIcon = driver.findElements(By.xpath("//*[@id='sort-icon']"));
	public List<WebElement> checkBoxes = driver.findElements(By.className("checkbox"));

	public List<WebElement> el = driver.findElements(By.xpath("//*"));
	public List<WebElement> tableHeaders = driver.findElements(By.xpath("//table/tbody/tr[1]/th\""));
	public WebElement table = driver.findElement(By.xpath("table[@id='mytable']"));
    
    public String mainWindow = driver.getWindowHandle(); 
	public String popUpWindow;
	public String currentUrl = "";
	
	public By alertYesButton = By.xpath("//[@id='Yes']");
	public By alertNoButton = By.xpath("//[@id='No']");
	public By alertokButton = By.xpath("//[@id='ok']");
	
	public String deletedRecord= "";
	public int deletedBatchId = 0;
	
	public String extractBatchId(String s)
	{
		 int deletedBatchId = new Scanner(deletedRecord).useDelimiter("\\D+").nextInt();
			deletedRecord = Integer.toString(deletedBatchId).trim();
			return deletedRecord;
	}
}
