@regression
Feature: Librarian should be able to add users with valid info

  Background: User should land on a homepage
    Given user is on the homePage
    Given user is successfully logged in
	#AC:
	#1. Add users with all valid info.
	#2. Librarians able to close the add user window with "close" button
	#3. Librarians able to edit user info.


  @G26-96
  Scenario Outline:
    When librarian clicks on Add User button
    When librarian should see Add User prompt window
    And I generate new full name and email address and save it as "fullName" and "email"
    And librarian can input new user's name "fullName"
    And librarian can input new user's password "<Password>"
    And librarian can input new user's email "email"
    And librarian can input new user's user group"<User Group>"
    And librarian can input new user's status "<Status>"
    And librarian can input new user's start date"<Start Date>"
    And librarian can input new user's end date "<End Date>"
    And librarian can input new user's address "<Address>"
    And librarian should be able to click on Save Changes
    Then new user "fullName" is successfully created

    Examples:
      | Password | User Group | Status   | Start Date | End Date   | Address         | emailAddress |
      | 123@456# | Students   | ACTIVE   | 2021/03/01 | 2022/03/01 | San Diego, Ca   | email        |
      | 567@89&$ | Librarian  | INACTIVE | 2022/02/01 | 2023/02/01 | Los Angeles, Ca | email        |

  @G26-96
  Scenario: librarian should be able to close the Add User window with Close Button
    When librarian is on the add user window and clicks Close Button
    Then librarian should be able close Add User input window

  @G26-96
  Scenario: librarian should be able to edit user info
    When librarian clicks Edit User button
    And librarian is able to see Edit User Information window
    Then librarian can edit any user info and save changes