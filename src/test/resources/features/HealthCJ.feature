@HealthCJ
Feature: Health Journey functionality
  Background: Login Application
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

#  Scenario Outline: validate the error msg while keeping name and mobile no as blank in Health page
#    When Click on Sell now modules
#    When Click on the Health buttons
#    And Enter the detail in Health landing page "<FullName>","<MobileNo>"
#    Then validate the error msg
#    Examples:
#      |FullName|MobileNo|
#      |||


    Scenario Outline: Verify User should be able to enter the details in Health page
      When Click on Sell now modules
      When Click on the Health buttons
      And Enter the detail in Health landing page "<FullName>","<MobileNo>"
      Then user should be able to navigate to member detail
      And user should enter the mandatory fields on member screen "<eldestmemberage>"
      And select City "<city>"
      And select existing illness and click on View Plan
      And click on premium button of NivaBupa
      And click on proceed to proposal page
      Examples:
      |FullName|MobileNo|eldestmemberage|city|
      |Test Automation|9810168351|35    |Noida|

