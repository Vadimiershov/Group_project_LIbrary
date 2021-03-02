@smoke_test
Feature: As a students, I should be able to see tables with default info

  #@studentTables #name will be  from Jira
  Scenario: Table column names
    Given the user on the homepage
    Then the user should see the following column names:
      | Actions     |
      | ISBN        |
      | Name        |
      | Author      |
      | Category    |
      | Year        |
      | Borrowed By |
