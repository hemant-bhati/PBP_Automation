@MappingRequest
Feature: Request Offline Quote
  Background: Login functionality
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: Generate Request Offline Quote
    When click on Request Offline Quote navigations "<prodID>","<custName>", "<regisNum>","<polNum>","<preMium>", "<docUpload>"
    Then Open the Admin Panel and search ticket "<prePolNum>", "<netPremium>"
    Then click on verify button under Add New Remarks section
    Then fill all mandatory inputs on policy details

#    Then Click on Tickets
    Examples:
      |prePolNum|prodID|custName|regisNum|preMium|docUpload|polNum|netPremium|
      |2872665565|186  |Automation User|RJ09RG8899|56000  |D:\PB Partners\POSP\OCR\Reliance\reliance car comp.pdf|hu78pyc76|12596|
