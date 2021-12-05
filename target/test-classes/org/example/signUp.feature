Feature: Testing the SignUp page

  Background:
    Given the home page is opened
    And the Sign In link is clicked

    Scenario Outline:
      Given the Sign Up '<field>' is filled with '<parameter>'
      When the Create an account button is clicked
      Then the Sign Up '<msg>' error message is shown
      Examples:
        | field        | parameter         | msg                                                                                                                  |
        | email_create |                   | Invalid email address.                                                                                               |
        | email_create | invalid.email.com | Invalid email address.                                                                                               |
        | email_create | valid@email.com   | An account using this email address has already been registered. Please enter a valid password or request a new one. |

    Scenario:
      Given the Sign Up "email_create" is filled with 'liboyi202109@163.com'
      Given the Create an account button is clicked
      Then the Sign Up "Register" Button is shown