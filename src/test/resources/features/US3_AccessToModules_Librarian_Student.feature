#@modules
Feature: Access to modules functionality
  As a user, I should be able to see several modules once I login.

  Background: User already on the login page
    Given user is on the login page

  #@student
  Scenario: Students should have access to 2 module
    Given the student on the home page
    Then the user should see following modules
      | Books           |
      | Borrowing Books |

  #@librarian
  Scenario: Librarians  should have access to 3 modules
    Given the librarian on the homepage
    Then the user should see following modules
      | Dashboard       |
      | Users           |
      | Books           |
