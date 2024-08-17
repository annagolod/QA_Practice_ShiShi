package pages;

import dto.UserDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginUserPageRu extends BasePage{
    public LoginUserPageRu(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }
    @FindBy(xpath = "//input[@id='identity']")
    WebElement fieldEmail;
    @FindBy(xpath = "//input[@id='password']")
    WebElement fieldPassword;
    @FindBy(xpath = "//input[@name='submit']")
    WebElement btnSubmit;

    public LoginUserPageRu typeLoginForm(UserDto userDto) {
        fieldEmail.sendKeys(userDto.getEmail());
        fieldPassword.sendKeys(userDto.getPassword());
        return this;
    }
    public UserPageRu submitLoginForm(){
        btnSubmit.click();
        return new UserPageRu(driver);
    }

    public boolean loginIsSuccessful(){
        return isElementPresent(By.xpath("//a[@href='auth/user']"));
    }

}
