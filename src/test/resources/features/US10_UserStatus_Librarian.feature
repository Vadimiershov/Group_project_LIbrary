#@smoke_test
Feature: User status
  As a librarian user I should be able to check Active/Inactive status through dropdown Status

  Background:
    Given User login as a librarian
    And User click on "Users" link
  @UserStatus
  Scenario: As a librarian user I should see Active/Inactive options in Status dropdown
    When User clicks on Status Dropdown
    Then User should see the following options
      |ACTIVE|
      |INACTIVE|
  @UserStatus

  Scenario Outline: As a librarian user is able to select "<status>" status and see only "<status>" Status in the Table
    When User clicks on Status Dropdown
    And User select "<status>" status
    Then User should see only "<status>" users in the table below under Status column
    Examples:
      |status|
      |ACTIVE|
    |INACTIVE|

