@MappingRequestCVMagma
Feature: Raise Mapping Request of CV Magma
  Background: Login functionality
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: Generate Raise mapping request for CV (Magma)
    When click on Request offline Quote button on left navigation
    When click on Raise mapping request under mapping and fill mandatory fields "<prodID>","<custName>", "<regisNum>","<polNum>","<premiumvalue>", "<docUpload>"
    Then Open the Admin Panel and search ticket through view ticket section "<prePolNum>", "<netPremium>"
    Then click on Edit button of respective ticket through the grid
    Then click on Verify radio button under Add New Remarks section
    Then fill all the mandatory fields on policy details
    Then click on the update button
    Then verify the lead values from UI and DB

#    Then Click on Tickets
    Examples:
      |prePolNum|prodID|custName|regisNum|premiumvalue|docUpload|polNum|netPremium|
      |2872665565|188  |Automation User|RJ09RG8899|56000  |D:\PB Partners\POSP\OCR\Magma\CV_comp_PCV.pdf|hu78pyc76|12596|
