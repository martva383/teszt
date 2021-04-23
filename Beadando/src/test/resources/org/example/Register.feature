Feature: automation practice register

  Background:
    Given the home page is opened
    And the sign in link is clicked

  Scenario:
    Given the create account button is clicked
    Then no email message is shown

  Scenario Outline:
    Given the email field is populated with '<value>'
    And the create account button is clicked
    Then invalid email message is shown
    Examples:
      | value |
      | testEmail |
      | wrongemail@hu |
      | @email.com |

  Scenario:
    Given the email field is populated
    And the create account button is clicked
    Then register form is opened