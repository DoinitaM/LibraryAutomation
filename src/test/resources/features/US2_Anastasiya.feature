@wip
Feature: As a librarian, I want to know borrowed books number
  @db
  Scenario: verify the total amount of borrowed books
    Given user login as a "librarian" - AZ
    When user take borrowed books number - AZ
    Then borrowed books number information must match with DB - AZ