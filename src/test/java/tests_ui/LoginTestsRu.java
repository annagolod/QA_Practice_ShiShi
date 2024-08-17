package tests_ui;

import config.ApplicationManager;
import dto.UserDto;
import helpers.PropertiesReader;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePageRu;
import pages.LoginUserPageRu;

import static pages.BasePage.clickBtnLoginHeader;
import static pages.BasePage.pause;

public class LoginTestsRu extends ApplicationManager {
    LoginUserPageRu loginUserPageRu;

    @BeforeMethod
    public void goToLoginUserPageRu() {
        new HomePageRu(getDriver());
        loginUserPageRu = clickBtnLoginHeader();
    }

    @Test
    public void loginPositiveTest() {
        UserDto userDto = UserDto.builder()
                .email(PropertiesReader.getProperty("data.properties", "email"))
                .password(PropertiesReader.getProperty("data.properties", "password"))
                .build();
        pause(3);
        loginUserPageRu.typeLoginForm(userDto);
        loginUserPageRu.submitLoginForm();
        Assert.assertTrue(BasePage.isElementPresent(By.xpath("//a[@href='auth/user']")));

    }
}