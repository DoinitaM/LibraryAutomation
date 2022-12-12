package com.library.step_definitions;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserStory6_DM_Defs {
BookPage bookPage = new BookPage();
String newBook;
String newBookName;
    @When("the librarian click to add book DM")
    public void the_librarian_click_to_add_book_dm() {

        bookPage.addBook.click();
        BrowserUtil.waitFor(3);
    }


    @When("the librarian enter book name {string} DM")
    public void the_librarian_enter_book_name_dm(String newBookName) {

bookPage.inputBookName.sendKeys(newBookName);

    }


    @When("the librarian enter ISBN {string} DM")
    public void the_librarian_enter_isbn_dm(String isbn) {

bookPage.inputIsbn.sendKeys(isbn);

    }


    @When("the librarian enter year {string} DM")
    public void the_librarian_enter_year_dm(String year) {

bookPage.imputYear.sendKeys(year);

    }


    @When("the librarian enter author {string} DM")
    public void the_librarian_enter_author_dm(String author) {

bookPage.inputAuthor.sendKeys(author);


    }


    @When("the librarian choose the book category {string} DM")
    public void the_librarian_choose_the_book_category_dm(String string) {


        bookPage.selectBook(string);


    }


    @When("the librarian click to save changes DM")
    public void the_librarian_click_to_save_changes_dm() {

bookPage.submintBttn.click();

        BrowserUtil.waitFor(4);
    }


    @Then("the librarian verify new book by {string} DM")
    public void the_librarian_verify_new_book_by_dm(String newBook) {

    //    BrowserUtil.waitForClickablility(bookPage.search, 5).sendKeys(newBook);

        //missing
  //      BrowserUtil.waitForClickablility(bookPage.editBook(newBook), 5).click();
        //added this
     //   this.newBook = newBook;

    }


    @Then("the librarian verify new book from database by {string} DM")
    public void the_librarian_verify_new_book_from_database_by_dm(String bookName) {


/*
        String actualBookName = bookPage.bookName.getAttribute("value");
        String actualAuthorName = bookPage.author.getAttribute("value");
        String actualYear = bookPage.year.getAttribute("value");
        ////
        //  String actualCategory = bookPage.bookCategory.getAttribute("value");
        BrowserUtil.waitFor(3);
        String actualBookCategory = bookPage.getSelectedOption(bookPage.bookCategoryDropdown);
        String actualDescription = bookPage.description.getAttribute("value");



 */
        bookPage.search.sendKeys(bookName+ Keys.ENTER);
        BrowserUtil.waitFor(3);

        List<String> list= new ArrayList<>();
        for (WebElement each : bookPage.newBookInfo) {
            list.add(each.getText());
        }
        System.out.println("-----actual data------");
        list.remove(0);
        list.remove(list.size()-1);
        System.out.println(list);
        BrowserUtil.waitFor(2);
       String actualISBN = list.get(0);
        System.out.println(actualISBN);
       String actualBookName = list.get(1);
        System.out.println(actualBookName);
       String  actualAuthorName = list.get(2);
        System.out.println(actualAuthorName);
       String  actualBookCategory = list.get(3);
        BrowserUtil.waitFor(2);
        System.out.println(actualBookCategory);
       String actualYear = list.get(4);
        System.out.println(actualYear);
     //  String actualDescription = list.get(5);
      //  System.out.println(actualDescription);




        BrowserUtil.waitFor(4);
        //   DB_Util.runQuery("select name, author,year from books where name='Chordeiles minor'");

        String query = "select b.name as BookName, author, isbn, year, bc.name as BookCategory, b.description as description from books b inner join book_categories bc on b.book_category_id = bc.id where b.name = '"+bookName+"'";
        DB_Util.runQuery(query);

        Map<String, String> bookInfo = DB_Util.getRowMap(1);

        System.out.println("---- DATA FROM DATABASE ---- ");
        String expectedBookName = bookInfo.get("BookName");
        System.out.println(expectedBookName);
        String expectedAuthorName = bookInfo.get("author");
        System.out.println(expectedAuthorName);
        String expectedYear = bookInfo.get("year");
        System.out.println(expectedYear);
        String expectedBookCategory = bookInfo.get("BookCategory");
        System.out.println(expectedBookCategory);
      //  String expecteDescription = bookInfo.get("description");
      //  System.out.println(expecteDescription);

        BrowserUtil.waitFor(4);
        Assert.assertEquals(expectedBookName,actualBookName);

        Assert.assertEquals(expectedAuthorName,actualAuthorName);
        Assert.assertEquals(expectedYear,actualYear);
        BrowserUtil.waitFor(4);
        Assert.assertEquals(expectedBookCategory, actualBookCategory);
   //     Assert.assertEquals(expecteDescription, actualDescription);


    }



}
