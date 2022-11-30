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
List<String> actualColumns;
  //  @Given("Establish the database connection DM")
 //   public void establish_the_database_connection_dm() {

   //     DB_Util.createConnection();

  //  }

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
//////////////////////////////////////////////////////////////


    @When("Execute query to get all columns DM")
    public void execute_query_to_get_all_columns_dm() {
        DB_Util.runQuery("select * from users");
actualColumns = DB_Util.getAllColumnNamesAsList();
        System.out.println(actualColumns);

    }

    @Then("verify the below columns are listed in result DM")
    public void verify_the_below_columns_are_listed_in_result_dm(List<String> expectedColumns) {

        System.out.println(expectedColumns);

Assert.assertEquals(expectedColumns, actualColumns);



    }



}
