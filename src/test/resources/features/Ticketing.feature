@Ticket
Feature: Ticket functionality
  Background: Login in the system
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons
  Scenario:Ticket functionality
    Given Click on Ticket
    Then Click on New Ticket
