package com.library.step_definitions;

import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.sql.ResultSet;
import java.util.List;

public class UserStory1_DM_Defs {
   String allId;

    @Given("Establish the database connection DM")
    public void establish_the_database_connection_dm() {

        DB_Util.createConnection();

    }

    @When("Execute query to get all IDs from users DM")
    public void execute_query_to_get_all_i_ds_from_users_dm() {



        // DB_Util.runQuery("select id from users");
        DB_Util.runQuery("select count(id)  from users");
    allId = DB_Util.getFirstRowFirstColumn();
        System.out.println(allId);

    }

    @Then("verify all users has unique ID DM")
    public void verify_all_users_has_unique_id_dm() {
DB_Util.runQuery("select count( distinct id)  from users;");

String allDistinctId = DB_Util.getFirstRowFirstColumn();
        System.out.println(allDistinctId);

        Assert.assertEquals(allDistinctId, allId);
    }



}
