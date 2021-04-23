Feature: automation practice contact
  Background:
    Given the home page is opened
    And user clicks on the contact us button

  Scenario: user tries to send empty message
    Given user enters valid email address
    And user clicks on the send button
    Then the message cannot be blank error message is shown

  Scenario: user enters invalid email address
    Given user enters invalid email address
    And user clicks on the send button
    Then invalid email address error message is shown

  Scenario: user successfully sends message
    Given user enters valid email address
    And user enters message
    And user selects a subject
    And user clicks on the send button
    Then your message has been successfully sent to our team message is shown