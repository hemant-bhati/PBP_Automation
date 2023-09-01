@MappingRequest2WICICI
Feature: Raise Mapping Request of ICICI
  Background: Login functionality
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: Generate Raise mapping request for TW (ICICI)
    When click on Request offline Quote left navigation
    When click on Raise mapping request and fill mandatory fields "<prodID>","<custName>", "<regisNum>","<polNum>","<premiumvalue>", "<docUpload>"
    Then Open Admin Panel and search ticket through view ticket section "<prePolNum>", "<netPremium>"
    Then click on Edit icon of respective ticket through the grid
    Then click on verify radio button under Add New Remarks section
    Then fill all mandatory fields on policy details
    Then click on update button
    Then verify the lead value from UI and DB

#    Then Click on Tickets
    Examples:
      |prePolNum|prodID|custName|regisNum|premiumvalue|docUpload|polNum|netPremium|
      |2872665565|187  |Automation User|RJ09RG8899|56000  |D:\PB Partners\POSP\OCR\ICICI\icici_two_wheeler.pdf|hu78pyc76|12596|
