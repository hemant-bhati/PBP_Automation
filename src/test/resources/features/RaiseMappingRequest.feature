@MappingRequest
Feature: Request Offline Quote
  Background: Login functionality
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: Generate Request Offline Quote
    When click on Request Offline Quote navigations "<prodID>","<custName>", "<regisNum>","<polNum>","<preMium>", "<docUpload>"
    Then Open the Admin Panel "<prePolNum>", "<netPremium>"

#    Then Click on Tickets
    Examples:
      |prePolNum|prodID|custName|regisNum|preMium|docUpload|polNum|netPremium|
      |2872665565|186  |Neha Gupta|RJ09RG8899|56000  |C:\Users\NehaGupta\Desktop\Policies folder\Reliance\reliance car saod.pdf|hu78hc100|12596|
