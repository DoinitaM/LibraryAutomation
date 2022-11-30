
@wip @db

Feature: As a librarian, I want to know what genre of books is being borrowed the most DM
  Scenario: verify the common book genre that’s being borrowed DM
    Given Establish the database connection DM
    When I execute query to find most popular book genre DM
    Then verify "Action and Adventure" is the most popular book genre. DM