Feature: Testing the Sign In page

  Background:
    Given the home page is opened
    And the Sign In link is clicked

  Scenario Outline:
    Given the Sign In '<field>' is filled with '<parameter>'
    When the Sign In button is clicked
    Then the Sign In '<msg>' error message is shown
    Examples:
      | field | parameter         | msg                        |
      | email |                   | An email address required. |
      | email | invalid.email.com | Invalid email address.     |
      | email | valid@email.com   | Password is required.      |

  Scenario:
    Given the Sign In "email" is filled with 'test@email.com'
    Given the Sign In "passwd" is filled with '123456'
    When the Sign In button is clicked
    Then the Sign In "Authentication failed." error message is shown

  Scenario:
    Given the Sign In "email" is filled with 'liboyi201809@163.com'
    Given the Sign In "passwd" is filled with 'Lby123456.'
    When the Sign In button is clicked
    Then the Sign In "Welcome to your account. Here you can manage all of your personal information and orders." info is shown

