package com.library.step_definitions;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserStory2_DM_Defs {
LoginPage loginPage = new LoginPage();
DashBoardPage dashBoardPage = new DashBoardPage();
String actualborrowedBooksNumber;


    @Given("user login as a librarian DM")
    public void user_login_as_a_librarian_dm() {

        loginPage.login("librarian");

    }

    @When("user take borrowed books number DM")
    public void user_take_borrowed_books_number_dm() {
        BrowserUtil.waitFor(4);
 actualborrowedBooksNumber = dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualborrowedBooksNumber = " +  actualborrowedBooksNumber);


    }

    @Then("borrowed books number information must match with DB DM")
    public void borrowed_books_number_information_must_match_with_db_dm() {

        DB_Util.runQuery("select count(*) from book_borrow\n" +
                "where is_returned=0");

        String expectedBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();
        System.out.println(" expectedBorrowedBooksNumber = " + expectedBorrowedBooksNumber);
        Assert.assertEquals(expectedBorrowedBooksNumber, actualborrowedBooksNumber);

    }

}
