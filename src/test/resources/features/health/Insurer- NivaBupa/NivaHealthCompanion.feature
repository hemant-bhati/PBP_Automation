#  Scenario: Niva Health Companion
#   1)Gender - Male
#   2)Combination - 2A+1K
#   3)City - Delhi
#   4)Cover - 7.5 lakh(Non-Pos)
#   5)Plan - Health Companion
#   6)Riders - Safeguard Benefit

@HealthCompanion
Feature: Health Journey
  Background: Login Application
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: Verify User should be able to enter the details in Health page
    When Click on the sell now button
    When Click on the Health Module
    And  Enter the detail on Health page "<FullName>","<MobileNo>"
    Then user should be able to navigate member detail
    And user should enter the details on the member screen "<eldestmemberage>","<eldestchildage>"
    And User should be able to select City Name "<city>"
    And select existing illness and click on View Plan checkbox
    And Enter the spouse age through edit member on the quote page
    And Enter ChildRelationship through the edit members
    And click on cover ammount dorp down button
    And Select the 7.5 lakhs suminsurred
    And Click on Apply button
    And click on the premium button of healthcompanion of niva
    And click on the proceed to proposal Page after adding rider
    And Enter details on proposer details screen "<panCard>","<address>","<contactEmail>","<emergencyMobile>"
    And Enter details of the member on member details screen "<dob>","<occupation>","<heightFeet>","<heightInch>","<weight>","<spouseName>","<spouseDOB>","<spouseOccupation>","<spouseHeightFeet>","<spouseHeightInch>","<spouseWeight>"
    And Enter Details of the child on the member details Screen "<childName>","<childdob>","<childHeightFeet>","<childHeightInch>","<childweight>"
    And Enter details of medical question on medical screen
    And Enter details on The Nominee page
    And check Declaration popup
    And move the POSP parent portal
    And click the Lead tab
    And verify Lead ID from UI and DB
    And click Continue button from Lead section
    And click proceed to payment page
    And navigate payment page and fill all mandatory entries


    Examples:
      |FullName|MobileNo|eldestmemberage|eldestchildage|city|panCard|address|contactEmail|emergencyMobile|dob|occupation|heightFeet|heightInch|weight|spouseName|spouseDOB|spouseOccupation|spouseHeightFeet|spouseHeightInch|spouseWeight|childName|childdob|childHeightFeet|childHeightInch|childweight|
      |Ankit sharma|7701906615|35    |       5          |Delhi |AYMPB1667K|Agra flat 45|test@gmail.com|9411073568 |01-01-1988|1|60    |8         |72    |Pooja k   |01-01-1993|5     |60               |4               |68          |Rahul Sharma  |02-02-2018|36  |4         |35    |




