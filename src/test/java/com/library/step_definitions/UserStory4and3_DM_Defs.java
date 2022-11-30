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

import java.util.List;
import java.util.Map;

public class UserStory4and3_DM_Defs {

LoginPage loginPage = new LoginPage();
DashBoardPage dashBoardPage = new DashBoardPage();
BookPage bookPage = new BookPage();
List<String> actualCategoryList;


    @Given("I login as a librarian DM")
    public void i_login_as_a_librarian_dm() {

loginPage.login("librarian");


    }

    @Given("I navigate to {string} page DM")
    public void i_navigate_to_page_dm(String module) {

dashBoardPage.navigateModule(module);

    }

    @When("I open book {string} DM")
    public void i_open_book_dm(String bookName) {

        BrowserUtil.waitForClickablility(bookPage.search, 5).sendKeys(bookName);

        //missing
       BrowserUtil.waitForClickablility(bookPage.editBook(bookName), 5).click();
    }

    @Then("book information must match the Database DM")
    public void book_information_must_match_the_database_dm() {


        BrowserUtil.waitFor(4);
        System.out.println("-----Assertion step-----");
        System.out.println(bookPage.bookName.getText());//won't run anything
        System.out.println("getAttribute(value)--> "+bookPage.bookName.getAttribute("value"));


        String actualBookName = bookPage.bookName.getAttribute("value");
        String actualAuthorName = bookPage.author.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");

        BrowserUtil.waitFor(4);
        DB_Util.runQuery("select name, author,year from books where name='Chordeiles minor'");

        Map<String, String> bookInfo = DB_Util.getRowMap(1);
        System.out.println("---- DATA FROM DATABASE ---- ");
        String expectedBookName = bookInfo.get("name");
        String expectedAuthorName = bookInfo.get("author");
        String expectedYear = bookInfo.get("year");

        BrowserUtil.waitFor(4);
        Assert.assertEquals(expectedBookName,actualBookName);
        Assert.assertEquals(expectedAuthorName,actualAuthorName);
        Assert.assertEquals(expectedYear,actualYear);

    }

    /////////////////////////////////////////////////////////////////////////////////////

    @When("I take all book categories in UI DM")
    public void i_take_all_book_categories_in_ui_dm() {
        actualCategoryList=BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
        actualCategoryList.remove(0);
        System.out.println("actualCategoryList = " + actualCategoryList);
    }


    @When("I execute query to get book categories DM")
    public void i_execute_query_to_get_book_categories_dm() {

DB_Util.runQuery("select name from book_categories");


    }

    @Then("verify book categories must match book_categories table from db DM")
    public void verify_book_categories_must_match_book_categories_table_from_db_dm() {

        List<String> expectedCategoryList =  DB_Util.getColumnDataAsList(1);

        System.out.println("expectedCategoryList = " + expectedCategoryList);
        System.out.println("----assert-----");
        //compare
        Assert.assertEquals(expectedCategoryList, actualCategoryList);

    }

}
