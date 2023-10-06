@MotorRequestCar
Feature: New Motor Request of Car
  Background: Login functionality
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: Generate New Motor Request for Car
    When Click on New Motor Request
    Then Click on Vehicle details,Registration Date, Registration NO, "<registraNum>"
    Then Choose Insurers
    Then IDV value, customer-email, Mobile no. and Pan number "<idvValue>", "<custemail>", "<mobileNo>", "<panNo>"
    Then choose DOB
    Then upload RC "<rc>"
    Then Choose Add-ons



    Examples:
    |registraNum|idvValue|custemail|mobileNo|panNo|rc|
    |HR01th6767|50000|nehagupta@pbpartners.com|8889099999|CKIPN9898J|C:\Users\NehaGupta\Desktop\Policies folder\Reliance\reliance car saod.pdf|
