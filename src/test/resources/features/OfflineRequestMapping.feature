@RequestOfflineQuote
Feature: Request Offline Quote
  Background: Login functionality
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario: Generate Request Offline Quote
   When click on Request Offline Quote navigations



