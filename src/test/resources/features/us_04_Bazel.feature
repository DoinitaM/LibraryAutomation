Feature: As a data consumer, I want UI and DB book information are match.

  Scenario: Verify book information with DB
    Given NB_I login as a "librarian"
    And NB_I navigate to "Books" page
    When NB_I open book "Chordeiles minor"
    Then BB_book information must match the Database for "Chordeiles minor"
