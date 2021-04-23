Feature: automation practice newsletter

  Background:
    Given the home page is opened


  Scenario Outline:
    Given the '<field>' is filled with '<parameter>'
    When user click news letter subscription button
    Then the '<msg>' message is shown
    Examples:
      | field            | parameter                 | msg                        |
      | newsletter-input |                           | Newsletter : Invalid email address. |
      | newsletter-input | invalid.email.com         | Newsletter : Invalid email address.  |
      | newsletter-input | valid@gmail.hu            | Newsletter : This email address is already registered.     |
      | newsletter-input | v2a422l322341id@gmail.hu   | Newsletter : You have successfully subscribed to this newsletter.    |

