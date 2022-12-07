package com.library.pages;


import com.library.utility.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesPage extends CommonAreaPage{

    public CategoriesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "inputEmail")
    public WebElement emailBox;

    @FindBy(id = "inputPassword")
    public WebElement passwordBox;

    @FindBy(tagName = "button")
    public WebElement loginButton;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(xpath = "//span[normalize-space()='Books']")
    public WebElement Books;

    public void login(String email,String password) {

        emailBox.sendKeys(email);
        passwordBox.sendKeys(password);
        loginButton.click();

    }

}
