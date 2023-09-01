@MappingRequestCarReliance
Feature: Raise Mapping Request of Reliance
  Background: Login functionality
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: Generate Raise mapping request for Car (Reliance Ins)
    When click on Raise mapping navigation "<prodID>","<custName>", "<regisNum>","<polNum>","<premiumvalue>", "<docUpload>"
    Then Open the Admin Panel and search ticket "<prePolNum>", "<netPremium>"
    Then click on verify button under Add New Remarks section
    Then fill all mandatory inputs on policy details
    Then verify the lead id from UI and DB


#    Then Click on Tickets
    Examples:
      |prePolNum|prodID|custName|regisNum|premiumvalue|docUpload|polNum|netPremium|
      |2872665565|186  |Automation User|RJ09RG8899|56000  |D:\PB Partners\POSP\OCR\Reliance\reliance car comp.pdf|hu78pyc76|12596|
