 @db
Feature: As a data consumer, I want the user information are stored in mySql DB correctly in users table. DM


  Background:
    Given Establish the database connection DM

  Scenario: verify users has unique IDs DM
    When Execute query to get all IDs from users DM
    Then verify all users has unique ID DM


  Scenario: verify users table columns DM
    When Execute query to get all columns DM
    Then verify the below columns are listed in result DM
      | id            |
      | full_name     |
      | email         |
      | password      |
      | user_group_id |
      | image         |
      | extra_data    |
      | status        |
      | is_admin      |
      | start_date    |
      | end_date      |
      | address       |