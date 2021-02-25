Feature: User Group
  As a librarian user I should be able to check User Group as All/Librarian/Students through dropdown

  Background:
    Given User login as a librarian
    And User click on "Users" link
  #@UserGroup
  Scenario: As a librarian user I should see All/Librarian/Students option in User Categories dropdown menu
    When User clicks in User Group Dropdown
    Then User should see the following options in User Group dropdown
      |ALL|
      |Librarian|
      |Students|

  #@UserGroup
  Scenario: As a librarian user I able to choose "ALL" option from User Categories dropdown menu and see students and librarians in Group column
    When User clicks in User Group Dropdown
    And User select "ALL" option in User Group Dropdown
    Then User able to see "Students"and"Librarian" in Group Column

 # @UserGroup
  Scenario: As a librarian user I able to choose "Students" option from User Categories dropdown menu and see only students in Group column
    When User clicks in User Group Dropdown
    And User select "Students" option in User Group Dropdown
    Then User able to see only "Students" in Group Column

  #@UserGroup
  Scenario: As a librarian user I able to choose "Librarian" option from User Categories dropdown menu and see only librarian in Group column
    When User clicks in User Group Dropdown
    And User select "Librarian" option in User Group Dropdown
    Then User able to see only "Librarian" in Group Column