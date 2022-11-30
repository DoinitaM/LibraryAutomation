@wip @db

Feature: As a librarian, I want to know borrowed books number DM

  Scenario: verify the total amount of borrowed books DM
    Given user login as a librarian DM
    When user take borrowed books number DM
    Then borrowed books number information must match with DB DM