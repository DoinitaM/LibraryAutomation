
Feature: As a data consumer, I want UI and DB book categories are match.

  @us03
  Scenario: verify book categories with DB FM
    Given Given the user logged in  "librarian55@library" and "67UQi3Ol" FM
    When I navigate to "Books" page FM
    And I take all book categories in UI FM
    And I execute query to get book categories FM
    Then verify book categories must match book_categories table from db FM