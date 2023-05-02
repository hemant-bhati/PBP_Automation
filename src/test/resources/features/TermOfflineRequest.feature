@TermRequest
Feature: Term Offline Request functionality
  Background: Login in the system

    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: Term Offline Request functionality
#    When Enter mobile number "<enterMobileNumber>"
    Given Click on the the New Offline Term Request
    Then Click on the New Term Request
    When Enter the customer name "<customerName>", "<customerEmail>","<customerMobileNo>"
    When Enter pincode "<pincode>", "<DOB>", "<dateOBooking>", "<annualIncome>"
    When Enter paymentpayingterm "<PPT>", "<policyTerm>", "<sumAssured>"
    When Enter premium "<premium>"
    When  Select  Payment Frequency "<paymentFrequency>", "<custOccupation>"
    When Select gender "<gender>"
    When Select business type
    When Select policy type "<policyType>"
    When Select Insurer "<insurer>"
    When Select Plan name "<planNames>"
    When Click on Request quote button


    Examples:
    |enterMobileNumber|customerName|customerEmail|customerMobileNo|pincode|DOB|dateOBooking|annualIncome|PPT|policyTerm|sumAssured|premium|paymentFrequency|custOccupation|gender|policyType|insurer|planNames|
    |IP9022|Neha Gupta|nehagupta@pbpartners.com|79829423302|110006|09/01/1996|02/03/2023   |800000      |4  |8         |700000|4000|Quarterly|Self Employed |1|0|Bajaj Allianz Life Insurance Company Ltd|Bajaj Smart Protect Goal Life Trop Cover Plan |