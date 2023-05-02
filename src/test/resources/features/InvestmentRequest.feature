@InvestmentRequest
Feature: Investment Offline Request functionality
  Background: Login in the system
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: Investment Offline Request functionality
    Given Click on the the New Offline investment Request
    Then Click on the New Investment Request
    When Enter the customer name "<customerName>", "<customerEmail>","<customerMobileNo>"
    When Enter the pincode "<pincode>", "<DOB>", "<dateOBooking>", "<annualIncome>"
    When Enter the paymentpayingterm "<PPT>", "<policyTerm>", "<sumAssured>"
    When Enter the premium "<premium>"
    When  Select the Payment Frequency "<paymentFrequency>", "<custOccupation>"
    When Select gender "<gender>"
    When Select business type
    When Select policy type "<policyType>"
    When Select number of adults "<noOfAdults>"
    When Select number of children "<noOfChildren>"
    When Select Eldest member age "<memberAge>"
    When Select Insurer "<insurer>"
    When Select Plan name "<planNames>"
    When Click on Request quote button

    Examples:
    |customerName|customerEmail|customerMobileNo|pincode|DOB|dateOBooking|annualIncome|PPT|policyTerm|sumAssured|premium|paymentFrequency|custOccupation|gender|policyType|noOfAdults|noOfChildren|memberAge|insurer|planNames|
  |Sachin Khulve|nehagupta@pbpartners.com|7982942320|122002|06/12/1999|28/12/2023|1100000|3|6|600000|30000|Monthly|Salaried|2|1|2|2|34|SBI Life Insurance Company Ltd|eWealth Insurance|


