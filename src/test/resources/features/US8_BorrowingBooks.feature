Feature: Borrow
  I should  be able to see my borrowing books

  #@borrowBooks
  Scenario: borrowing books table columns names
    Given the user on the homepage
    When the user click Borrowing Books module
    Then the user should see the following column names under Borrowed Books:
      | Action              |
      | Book Name           |
      | Borrowed Date       |
      | Planned Return Date |
      | Return Date         |
      | Is Returned ?       |