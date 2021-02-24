
@wip
Feature: As a user, librarian and student are able to log out


  Scenario: Verify students can logout

    Given the user login as a "Test Student 11"
    When the user is on "books" page
    And the student clicks the dropdown button
    And the student clicks the logout button
    Then the user sees the loginPage

  Scenario: Verify librarians can logout

    Given the user librarian logs in as a "Test Librarian 11"
    When the librarian is on dashboard page
    And the librarian clicks the dropdown button
    And the librarian clicks the logout button
    Then the user librarian sees the loginPage