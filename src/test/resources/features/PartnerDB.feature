@PartnerDashboard
@Regression
Feature: Partner Dashboard functionality
  Background: Login functionality
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

    Scenario: Partner Dashboard functionality
      Given Validate Support Tickets tab under My Actionables
#      Then Validate Offline Request tab under My Actionables
      Then Validate Leads tab under My Actionables
      Then Click on continue button through leads


