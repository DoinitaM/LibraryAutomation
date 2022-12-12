Feature: As a data consumer, I want UI and DB book information are match
@wip @db
Scenario: Verify book information with DB
Given AA login as a "librarian"
And AA navigate to "Books" page
When AA open book "Chordeiles minor"
Then AA book information must match the Database for "Chordeiles minor"
