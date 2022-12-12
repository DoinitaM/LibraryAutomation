package com.library.step_definitions;

import com.library.pages.BookPage;
import com.library.pages.CommonAreaPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Map;

public class UI_DB_StepDef {

    LoginPage loginPage = new LoginPage();

    CommonAreaPage commonAreaPage = new CommonAreaPage();
    BookPage bookPage = new BookPage();

    DashBoardPage dashBoardPage = new DashBoardPage();


    @Given("AA login as a {string}")
    public void aa_login_as_a(String user) {

        loginPage.login(user);
        BrowserUtil.waitFor(3);

    }

    @Given("AA navigate to {string} page")
    public void aa_navigate_to_page(String module) {
        dashBoardPage.navigateModule(module);

    }

    @When("AA open book {string}")
    public void aa_open_book(String bookName) {
       // bookPage.search.sendKeys(bookName + Keys.ENTER);
        BrowserUtil.waitFor(2);
        BrowserUtil.waitForClickablility(bookPage.search,5).sendKeys(bookName);
        BrowserUtil.waitForClickablility(bookPage.editBook(bookName),5).click();


    }

    @Then("AA book information must match the Database for {string}")
    public void aa_book_information_must_match_the_database_for(String BookName) {
        BrowserUtil.waitFor(3);
        System.out.println("bookPage.bookName.getText() = " + bookPage.bookName.getText());

        String actualBookName = bookPage.bookName.getAttribute("value");
        String actualAuthorName = bookPage.author.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");

        DB_Util.runQuery("SELECT name,author,year FROM books where name='"+BookName+"'");

        Map<String, String> dataInfo = DB_Util.getRowMap(1);

        String expectedName = dataInfo.get("name");
        System.out.println("expectedName = " + expectedName);
        String expectedAuthor = dataInfo.get("author");
        System.out.println("expectedAuthor = " + expectedAuthor);
        String expectedYear = dataInfo.get("year");
        System.out.println("expectedYear = " + expectedYear);

        Assert.assertEquals(expectedName, actualBookName);
        Assert.assertEquals(expectedAuthor, actualAuthorName);
        Assert.assertEquals(expectedYear, actualYear);

        // DB_Util.runQuery("SELECT name,author,year FROM books where name='"+BookName+"'");


    }

}
