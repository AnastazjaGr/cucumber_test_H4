Feature: Test scenario for SearchField on Amazon

  Scenario: Search with  searchWord (negative)

    Given User is on "Home Page"

    When User enters searchWord  as "#87569ukraine" on "Home Page"

    Then User gets  message "No results for" on "Search Page"


  Scenario: Search with correct searchWord

    Given User is on "Home Page"

    When User enters searchWord  as "laptop" on "Home Page"

    Then User gets  text "laptop" on "Search Page"

  Scenario: Check product title

    Given User is on "Home Page"

    When User enters searchWord  as "Laptop Dell Inspiron 3510" on "Home Page"

    Then User gets products with "Dell Inspiron 3510" in the title on "Search Page"




