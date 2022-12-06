package com.library.pages;

import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BookPage extends CommonAreaPage {

    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(name = "name")
    public WebElement bookName;

    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;

    @FindBy(name = "year")
    public WebElement year;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(id = "description")
    public WebElement description;

    @FindBy(xpath = "//a[@class='btn btn-lg btn-outline btn-primary btn-sm add_book_btn']/..")
    public WebElement addBook;

@FindBy(xpath = "//input[@placeholder='Book Name']")
public WebElement inputBookName;

@FindBy(xpath = "//input[@name='isbn']")
public WebElement inputIsbn;

    @FindBy(xpath = "//input[@name='year']")
    public WebElement imputYear;


    @FindBy(xpath = "//input[@name='author']")
    public WebElement inputAuthor;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submintBttn;



    @FindBy(xpath = "//select[@id='book_group_id']")
    public WebElement bookCategory;

//added this
 //   @FindBy(xpath = "//a[contains(@class, 'btn-lg')]")
//    public WebElement addBook;

    @FindBy(name = "book_category_id")
    public WebElement categoryDropDown;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChangesBtn;
    @FindBy (xpath = "//select[@id='book_group_id']")
    public WebElement bookCategoryDropdown;


//addded
    @FindBy(xpath = "//table/tbody/tr[1]/td")
    public List<WebElement> newBookInfo;



    public void selectBook(String string) {

       Select selectBookCategory = new Select(bookCategory);
       selectBookCategory.selectByVisibleText(string);


}

    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

//added this
    public String getSelectedOption(WebElement e){
        Select select = new Select(e);
        return select.getFirstSelectedOption().getText();
    }

}
