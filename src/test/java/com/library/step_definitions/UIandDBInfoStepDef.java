package com.library.step_definitions;

import com.library.pages.BookPage;
import com.library.pages.CommonAreaPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.Map;

public class UIandDBInfoStepDef {

    LoginPage loginPage = new LoginPage();
    CommonAreaPage commonAreaPage = new CommonAreaPage();
    BookPage bookPage = new BookPage();

    @Given("AB I login as a {string}")
    public void ab_i_login_as_a_librarian(String user) {
       loginPage.login(user);
       BrowserUtil.waitFor(4);

    }
    @Given("AB I navigate to {string} page")
    public void ab_i_navigate_to_page(String moduleName) {
        new DashBoardPage().navigateModule(moduleName);


    }
    @When("AB I open book {string}")
    public void ab_i_open_book(String bookName) {
        BrowserUtil.waitFor(3);
        BrowserUtil.waitForClickablility( bookPage.search,5).sendKeys(bookName);
        BrowserUtil.waitForClickablility(bookPage.editBook(bookName),5).click();
    }
    @Then("AB book information must match the Database for {string}")
    public void ab_book_information_must_match_the_database(String bookName) {

        BrowserUtil.waitFor(3);
        System.out.println(bookPage.bookName.getText());
        String actualBookName = bookPage.bookName.getAttribute("value");
        String actualAuthor = bookPage.author.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");

        String query ="select name,author,year from books where name='"+bookName+"'";
        DB_Util.runQuery(query);

        Map<String,String> dataBase = DB_Util.getRowMap(1);

        String expectedName = dataBase.get("name");
        System.out.println(expectedName);
        String expectedAuthor = dataBase.get("author");
        System.out.println(expectedAuthor);
        String expectedYear = dataBase.get("year");
        System.out.println(expectedYear);

        Assert.assertEquals(expectedName,actualBookName);
        Assert.assertEquals(expectedAuthor,actualAuthor);
        Assert.assertEquals(expectedYear,actualYear);
    }

}
