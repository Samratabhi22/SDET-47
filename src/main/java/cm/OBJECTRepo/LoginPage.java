package cm.OBJECTRepo;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	//declaration
	@FindBy(name="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(name="login")
	private WebElement login;
	
	@FindBy(xpath ="//a[text()='Register']")
	private WebElement register;
	
	@FindBy(xpath="//a[text()='Login']")
	private WebElement loginLink;
	
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getUername() {
		return username;
	}


	public WebElement getPassword() {
		return password;
	}


	public WebElement getLogin() {
		return login;
	}
	
	public WebElement getRegister()
	{
		return register;
	}
	
	//utilization
	public void loginPage(String USERNAME, String PASSWORD)
	{
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		login.click();
		//register.click();

	}
	
	public void clickLoginlink()
	{
		loginLink.click();
	}
	
	
	
	
}

