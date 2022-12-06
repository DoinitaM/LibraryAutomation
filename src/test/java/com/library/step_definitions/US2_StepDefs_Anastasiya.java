package com.library.step_definitions;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US2_StepDefs_Anastasiya {
    LoginPage loginPage=new LoginPage();
    DashBoardPage dashBoardPage=new DashBoardPage();
    String actualBorrowedBooksNumber;
    @Given("user login as a {string} - AZ")
    public void userLoginAsAAZ(String user) {
        loginPage.login(user);
        BrowserUtil.waitFor(3);
    }
    @When("user take borrowed books number - AZ")
    public void user_take_borrowed_books_number_az() {
        actualBorrowedBooksNumber= dashBoardPage.borrowedBooksNumber.getText();
        System.out.println("actualBorrowedBooksNumber = " + actualBorrowedBooksNumber);
    }
    @Then("borrowed books number information must match with DB - AZ")
    public void borrowed_books_number_information_must_match_with_db_az() {
        String query = "select count(*) as borrowedBooks from users u\n" +
                "inner join book_borrow bb on u.id = bb.user_id\n" +
                "where is_returned=0";
        DB_Util.runQuery(query);
        String expectedBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();
        System.out.println("expectedBorrowedBooksNumber = " + expectedBorrowedBooksNumber);
        Assert.assertEquals(expectedBorrowedBooksNumber,actualBorrowedBooksNumber);
    }


}
