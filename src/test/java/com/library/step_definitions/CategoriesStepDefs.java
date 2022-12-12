package com.library.step_definitions;


import com.library.pages.CategoriesPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CategoriesStepDefs {
   //LoginPage loginPage = new LoginPage();

    CategoriesPage categoriesPage = new CategoriesPage();



    @Given("Given the user logged in  {string} and {string} FM")
    public void given_the_user_logged_in_and_fm(String email, String password) {
        categoriesPage.login(email, password);
        BrowserUtil.waitFor(2);
    }

    @When("I navigate to {string} page FM")
    public void i_navigate_to_page_fm(String book){
        System.out.println("bookName = " + book);


    }

    @When("I take all book categories in UI FM")
    public void i_take_all_book_categories_in_ui_fm() {
        new CategoriesPage().books.click();
        BrowserUtil.waitFor(2);

    }

    @When("I execute query to get book categories FM")
    public void i_execute_query_to_get_book_categories_fm() {

        new CategoriesPage().mainCategoryElement.click();
        BrowserUtil.waitFor(2);

    }

    @Then("verify book categories must match book_categories table from db FM")
    public void verify_book_categories_must_match_book_categories_table_from_db_fm() {

        String query="select name from book_categories";

        //run query to get all categoryList from Database
        DB_Util.runQuery(query);
    }
}