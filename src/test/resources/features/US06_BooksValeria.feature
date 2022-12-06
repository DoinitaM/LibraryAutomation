Feature: Books module
 User Story: As a librarian, I should be able to add new books to the library

  @db @TS11-132 @TS11-133 @us06
Scenario Outline: Adding new books to the library
Given the user logged in as "librarian" vb
When the user navigates to "Books" page vb
And the user clicks on Add Book vb
And the user enters "<BookName>"/"<ISBN>"/"<Year>"/"<Author>"/"<BookCategory>" and saves the changes vb
Then "The book has been created." message should be displayed vb
And new book should be added to the database vb
Examples:
| BookName              | ISBN     | Year | Author              | BookCategory            |
| Woe from Wit          | 09112021 | 1831 | Alexander Griboedov | Comic and Graphic Novel |
| Crime and Punishment  | 10112021 | 1866 | Fyodor Dostoevskiy  | Crime and Detective     |
| Heart of a Dog        | 11112021 | 1988 | Mikhail Bulgakov    | Science Fiction         |
