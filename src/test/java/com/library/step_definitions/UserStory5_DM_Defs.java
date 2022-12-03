package com.library.step_definitions;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class UserStory5_DM_Defs {

    String expectedBookName;
    @Given("Establish the database connection DM")
    public void establish_the_database_connection_dm() {

        // DB_Util.createConnection();


    }

    @When("I execute query to find most popular book genre DM")
    public void i_execute_query_to_find_most_popular_book_genre_dm() {


        DB_Util.runQuery("select bc.name,count(*) from book_borrow bb\n" +
                "                                 inner  join books b on bb.book_id = b.id\n" +
                "                                 inner join book_categories bc on b.book_category_id=bc.id\n" +
                "group by name\n" +
                "order by 2 desc");

 expectedBookName = DB_Util.getFirstRowFirstColumn();
        System.out.println(expectedBookName);


    }

    @Then("verify {string} is the most popular book genre. DM")
    public void verify_is_the_most_popular_book_genre_dm(String bookName) {
        System.out.println(bookName);

        Assert.assertEquals(expectedBookName, bookName);


    }

}
