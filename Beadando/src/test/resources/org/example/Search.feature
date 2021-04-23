Feature: automation practice search

  Background:
    Given the home page is opened

  Scenario:
    Given the search button is clicked
    Then please enter search keyword message is shown

  Scenario Outline:
    Given user entered '<value>' in '<field>'
    And the search button is clicked
    Then the '<message>' is shown
    Examples:
      | value    | field            | message                    |
      | noalma   | search_query_top | 0 results have been found. |
      | dress    | search_query_top | 7 results have been found. |
      | t-shirt  | search_query_top | 1 result has been found.   |
