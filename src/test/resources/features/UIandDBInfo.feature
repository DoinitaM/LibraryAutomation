
Feature: As a data consumer, I want UI and DB book information are match.
  @ang @db
  Scenario:  Verify book information with DB

    Given AB I login as a "librarian"
    And AB I navigate to "Books" page
    When AB I open book "Chordeiles minor"
    Then AB book information must match the Database for "Chordeiles minor"

