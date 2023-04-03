package cm.OBJECTRepo;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPagePage
{
	//declaration
	@FindBy(xpath ="//a[text()='Home']")
	private WebElement home;
	
	@FindBy(xpath ="//a[text()='Register']")
	private WebElement register;
	
	@FindBy(xpath ="//a[text()='Details/Update']")
	private WebElement DetailsAndUpdate;
	
	@FindBy(xpath ="//a[text()='Send SMS']")
	private WebElement SendSMS;
	
	@FindBy(xpath="//a[text()='Complaint List']")
	private WebElement complaintlist;
	
	@FindBy(xpath="//b[text()='Registered Users: ']")
	private  WebElement RegisteredUsers;
	
	@FindBy(xpath="//b[text()='Rooms for Rent: ']")
	private WebElement RoomsForRent;
	
	@FindBy(xpath ="//a[text()='Logout']")
	private WebElement logout;
	
	//initialization
	public DashBoardPagePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getHome() {
		return home;
	}

	public WebElement getRegister() {
		return register;
	}

	public WebElement getDetailsAndUpdate() {
		return DetailsAndUpdate;
	}

	public WebElement getSendSMS() {
		return SendSMS;
	}

	public WebElement getComplaintlist() {
		return complaintlist;
	}
	
	public WebElement getRegisteredUsers()
	{
		return RegisteredUsers;
	}
	
	public WebElement getRoomsForRent()
	{
		return RoomsForRent;
	}
	
	public WebElement logout()
	{
		return logout;
	}
	
	
	
	public void clickHome()
	{
		home.click();
	}
	
	public void clickRegister()
   {
		register.click();
   }
	
	public void clickDetailsAndUpdate()
	{
		DetailsAndUpdate.click();
	}
	
	public void clickSendSMS()
	{
		SendSMS.click();
	}
	
	public void clickComplaintlist()
	{
		complaintlist.click();
	}
	
	public void clickRegisteredUsers()
	{
		RegisteredUsers.click();
	}
	
	public void clickRoomsFOrRent()
	{
		RoomsForRent.click();
	}
	
	public void clickLogout()
	{
		logout.click();
	}
		
}

