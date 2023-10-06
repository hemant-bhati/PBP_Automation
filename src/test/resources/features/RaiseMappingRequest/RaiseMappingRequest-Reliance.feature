@MappingRequest
Feature: Raise Mapping Request of Reliance
  Background: Login functionality
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: Generate Request Offline Quote
    When click on Request Offline Quote navigation
    And Fill all the details of Raise Mapping Request "<prodID>","<custName>", "<regisNum>","<polNum>","<preMium>", "<docUpload>","<insurername>"
    Then Open the Admin Panel and search ticket "<prePolNum>", "<netPremium>"
    Then click on verify button under Add New Remarks section
    Then fill all mandatory inputs on policy details
#    Then After updating the policy details page clicked on the close button

#    Then Click on Tickets
    Examples:
      |prePolNum|prodID|custName|regisNum|preMium|docUpload|polNum|netPremium|insurername|
      |2872665565|186  |Automation User|RJ09RG8899|56000  |C:\Users\Ankitsharma3\Documents\reliance car comp.pdf|hu78pyc76|12596|Reliance|
