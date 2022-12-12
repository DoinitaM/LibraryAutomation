
 @db

 Feature: As a data consumer, I want UI and DB book information are match. DM

  Scenario: Verify book information with DB DM
    Given I login as a librarian DM
    And I navigate to "Books" page DM
    When I open book "Chordeiles minor" DM
    Then book information must match the Database DM


  Scenario: verify book categories with DB
    Given I login as a librarian DM
    When I navigate to "Books" page DM
    And I take all book categories in UI DM
    And I execute query to get book categories DM
    Then verify book categories must match book_categories table from db DM

