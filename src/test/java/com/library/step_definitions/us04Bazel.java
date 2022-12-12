package com.library.step_definitions;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class us04Bazel {
    LoginPage loginPage=new LoginPage();

    BookPage bookPage=new BookPage();

    DashBoardPage dashBoardPage=new DashBoardPage();
    @Given("NB_I login as a {string}")
    public void nb_i_login_as_a(String user) {
        loginPage.login(user);
        BrowserUtil.waitFor(4);
    }
    @Given("NB_I navigate to {string} page")
    public void nb_i_navigate_to_page(String moduleName) {
        new DashBoardPage().navigateModule(moduleName);
    }
    @When("NB_I open book {string}")
    public void nb_i_open_book(String bookName) {
        System.out.println("bookName = " + bookName);
        BrowserUtil.waitForClickablility(bookPage.search, 5).sendKeys(bookName);
        BrowserUtil.waitForClickablility(bookPage.editBook(bookName), 5).click();
    }
    @Then("BB_book information must match the Database for {string}")
    public void bb_book_information_must_match_the_database_for(String bookName) {
        BrowserUtil.waitFor(4);
        System.out.println(bookPage.bookName.getText());
        System.out.println(bookPage.bookName.getAttribute("value"));

        String actualBookName = bookPage.bookName.getAttribute("value");
        String actualAuthorName = bookPage.author.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");

        String query = "select name, author,year from books where name='"+bookName+"'";

        DB_Util.runQuery(query);

        Map<String, String> bookInfo = DB_Util.getRowMap(1);

        String expectedBookName = bookInfo.get("name");
        System.out.println(expectedBookName);
        String expectedAuthorName = bookInfo.get("author");
        String expectedYear = bookInfo.get("year");

        Assert.assertEquals(expectedBookName, actualBookName);
        Assert.assertEquals(expectedAuthorName, actualAuthorName);
        Assert.assertEquals(expectedYear, actualYear);
    }

}
