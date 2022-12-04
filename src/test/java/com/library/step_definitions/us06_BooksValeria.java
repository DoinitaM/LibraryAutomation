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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class us06_BooksValeria {

    BookPage bookPage = new BookPage();
    List<String> actualCategoryList;
    String expectedBookName;
    String expectedAuthor;
    String expectedISBN;
    String expectedCategory;
    String expectedYear;

    @Given("the user logged in as {string} vb")
    public void the_user_logged_in_as_vb(String user) {
        new LoginPage().login(user);
        BrowserUtil.waitFor(2);
    }
    @When("the user navigates to {string} page vb")
    public void the_user_navigates_to_page_vb(String module) {
        new DashBoardPage().navigateModule(module);
    }
    @When("the user clicks on Add Book vb")
    public void the_user_clicks_on_add_book_vb() {
       bookPage.addBook.click();
       BrowserUtil.waitFor(2);
    }
    @When("the user enters {string}\\/{string}\\/{string}\\/{string}\\/{string} and saves the changes vb")
    public void the_user_enters_and_saves_the_changes_vb(String bookName, String isbn, String year, String author, String bookCategory) {
        expectedBookName = bookName;
        expectedISBN = isbn;
        expectedYear = year;
        expectedAuthor = author;
        expectedCategory = bookCategory;

        bookPage.bookName.sendKeys(bookName);
        bookPage.isbn.sendKeys(isbn);
        bookPage.year.sendKeys(year);
        bookPage.author.sendKeys(author);

        BrowserUtil.waitForClickablility(bookPage.categoryDropDown, 5);
        BrowserUtil.selectByVisibleText(bookPage.categoryDropDown, bookCategory);
        bookPage.saveChangesBtn.click();
    }
    @Then("{string} message should be displayed vb")
    public void message_should_be_displayed_vb(String expectedMessage) {
        BrowserUtil.waitForVisibility(bookPage.toastMessage, 5);
        String actualMessage = new CommonAreaPage().toastMessage.getText();
        Assert.assertEquals("Success Message verification failed!", expectedMessage, actualMessage);

    }
    @Then("new book should be added to the database vb")
    public void new_book_should_be_added_to_the_database_vb() {

        DB_Util.runQuery("select b.name as book_name, b.author, b.isbn, b.year, bc.name as book_category from books b inner join book_categories bc on b.book_category_id = bc.id where b.name in ('"+expectedBookName+"')");

        List<String> actualBookInfo = DB_Util.getRowDataAsList(1);
        List<String> expectedBookInfo = new ArrayList<>(Arrays.asList(expectedBookName, expectedAuthor, expectedISBN, expectedYear, expectedCategory));

        Assert.assertEquals("Book with expected information doesn't exist in DataBase!", expectedBookInfo, actualBookInfo);
    }

}
