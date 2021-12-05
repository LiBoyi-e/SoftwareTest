Feature: Testing the Search page

  Background:
    Given the home page is opened

    Scenario Outline:
      Given the Search '<field>' is filled with '<parameter>'
      When the Search button is clicked
      Then the Search Result '<msg>' is shown
      Examples:
        | field            | parameter | msg                        |
        | search_query_top | dresses   | "DRESSES"                  |
        | search_query_top | t-shirt   | "T-SHIRT"                  |
        | search_query_top | coats     | 0 results have been found. |

    Scenario:
      Given the Search 'search_query_top' is filled with ''
      When the Search button is clicked
      Then the Search Result '0 results have been found.' is shown
