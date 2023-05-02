@NewOtherRequest
Feature: New Other Request functionality
  Background: Login in the system
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: New Other Request functionality
    Given Click on the Request Offline Quote
    Then Click on the New Other Request
    When select Product type "<productType>"
    When Select Policy Type "<otherPolicyType>"
    When Enter the customer name "<insuredName>", "<custEmail>","<custMobileNo>", "<customerAddress>", "<postcode>"
    When Select Insurer "<insurer>"
    When select Sum insured and address "<SI>", "<Address>"
    When Select Occupancies "<Occupancies>"
    When Enter risk Description "<riskDes>"
    When Click on proceed button

    Examples:
    |productType|otherPolicyType|insuredName|custEmail|custMobileNo|customerAddress|postcode|insurer|SI|Address|Occupancies|riskDes|
  |Fire and Burglary Package|0|Neha gupta|nehagupta@pbpartners.com|7980932320|Delhi Delhi|110004|Bajaj Allianz General Insurance Company Ltd|700000|Delhi Delhi Delhi|Fire - Carpenters, Wood wool Manufacturing, Furniture Manufacturing and other wood worker shops (excluding saw mill) (2034)|Risk Description|