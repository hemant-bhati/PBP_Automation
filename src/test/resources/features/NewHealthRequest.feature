@NewHealthRequest
Feature: New Other Request functionality
  Background: Login in the system
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

    Scenario Outline: New Health Request functionality
      Given Click on the Request Offline Quote
      Then Click on New health Request
      When Enter the customer name "<customerName>", "<customerEmail>","<customerMobileNo>"
      When Enter the Pin "<pincode>", "<DOB>", "<policyTerm>", "<sumAssured>", "<premium>"
      When select customer Occupation "<custOccupation>"


    Examples:
    |customerName|customerEmail|customerMobileNo|pincode|DOB|policyTerm|sumAssured|premium|custOccupation|
    |Neha gupta|nehagupta@pbpartners.com|7879909089|122002|06/12/1995|3|60000|20000|Salaried             |


