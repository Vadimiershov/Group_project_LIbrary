@G26-90

Feature: As a user, librarian and student are able to login with valid credentials US1

  Scenario Outline: As a user, librarian and student are able to login with valid credentials US1
    Given user has landed on a login page
    When given user login as a "<role>"
    Then the user on a "<page>"

    Examples:
      | role              | page      |
      | Test Librarian 11 | Dashboard |
      | Test Student 11   | Books     |
