#@smoke_test
Feature: User management table feature

  Scenario: Table columns names check
    Given I am on the login page
    And User login as a librarian
    And User click on "Users" link
    Then table should have following column names:
      | Actions   |
      | User ID   |
      | Full Name |
      | Email     |
      | Group     |
      | Status    |