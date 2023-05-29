@HealthJourney
Feature: Health Journey functionality
  Background: Login Application
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons
  Scenario Outline: Health journey Functionality
    When Click on Sell now module
    Given Click on the Health button
    Then Verify the title of Health journey landing page
    Then Enter the details Health landing page
    Then select combination and age
    Then Enter the State
    Then Choose Existing illness
    Then choose quote from the list
    Then click on proceed to proposal
    Then Fill Proposal form
    Then fill member details
    Then choose medical questions
    Then fill the nominee section
    Then Accept declaration pop-up
    Examples:
    ||
    ||


  Scenario Outline: Validate the Lead ID in DB which is created in previous scenario
    Then click on Lead navigation
    Examples:
    ||
    ||


