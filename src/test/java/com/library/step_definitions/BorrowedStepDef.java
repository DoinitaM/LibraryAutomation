package com.library.step_definitions;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utility.ConfigurationReader;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.*;

public class BorrowedStepDef {
String borrowedBookNumber;
    String expectedBorrowedBook;
    LoginPage loginPage=new LoginPage();
    DashBoardPage dashBoardPage=new DashBoardPage();

    @Given("user login as a librarian")
    public void user_login_as_a_librarian() {

       loginPage.emailBox.sendKeys(ConfigurationReader.getProperty("librarian_username"));
        loginPage.passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        loginPage.loginn.click();

    }
    @When("user take borrowed books number")
    public void user_take_borrowed_books_number() {
borrowedBookNumber=dashBoardPage.borrowedBooksNumber.getText();
        System.out.println(borrowedBookNumber);
    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() throws SQLException {

        Connection conn = DriverManager.getConnection(ConfigurationReader.getProperty("library2.db.url"),
                ConfigurationReader.getProperty("library2.db.username"),ConfigurationReader.getProperty("library2.db.password" ));

        // It helps us to execute queries
        Statement statement = conn.createStatement();

        // ResultSet will store data after execution.It stores only data (there is no table info )
        ResultSet rs = statement.executeQuery("select count(*) as borrowedBooks from users u\n" +
                        "                                          inner join book_borrow b on u.id = b.user_id where is_returned = 0");


while(rs.next()){
    expectedBorrowedBook  =rs.getString(1);
}




        Assert.assertEquals(expectedBorrowedBook,borrowedBookNumber);

    }


}
