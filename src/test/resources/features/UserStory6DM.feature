@wip @db
Feature: Books module
  As a librarian, I should be able to add new books to the library DM


  Scenario Outline: Verify added book is matching with DB DM
    Given I login as a librarian DM
    And I navigate to "Books" page DM
    When the librarian click to add book DM
    And the librarian enter book name "<Book Name>" DM
    When the librarian enter ISBN "<ISBN>" DM
    And the librarian enter year "<Year>" DM
    When the librarian enter author "<Author>" DM
    And the librarian choose the book category "<Book Category>" DM
    And the librarian click to save changes DM
    Then the librarian verify new book by "<Book Name>" DM
    Then the librarian verify new book from database by "<Book Name>" DM
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Clean Code a           | 09112021 | 2021 | Robert C.Martin | Drama                |
      | Head First Javaa       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guidea | 11112021 | 2006 | Mitch Lacey     | Short Story          |