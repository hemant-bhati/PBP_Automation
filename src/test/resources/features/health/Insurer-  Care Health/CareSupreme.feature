#  Scenario: Care Supreme ( Portability)
#   1)Gender - Male
#   2)Combination - 1A+1K
#   3)City - Delhi
#   4)Cover - 7 lakh(Non-Pos)
#   5)Plan - Care Supreme
#   6)Riders - Annual Health Check-up , Cumulative Bonus Super

@CareSupreme
Feature: Health Journey
  Background: Login Application
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: Verify User should be able to enter the details on the Health page
    When Click on sell now button
    When Click on Health Module
    And  Enter detail on Health page "<FullName>","<MobileNo>"
    Then user should be able to navigate to the member detail
    And  user should enter the details on member screen "<eldestmemberage>","<eldestchildage>"
    And  User should be able to select the City Name "<city>"
    And  select existing illness and click on the View Plan checkbox
    And  Enter  the spouse age through edit member on the quote page
    And  Enter Child Relationship through the edit members
    And  click on the cover ammount dorp down button
    And  Select the 7 lakhs suminsurred
    And  Click on the Apply button
    And  click on premium button of healthcompanion of niva
    And  click on proceed to proposal Page after adding rider
    And  Enter details on the proposer details screen "<panCard>","<address>","<contactEmail>","<emergencyMobile>"
    And  Enter details  the member on member details screen "<dob>","<occupation>","<heightFeet>","<heightInch>","<weight>","<spouseName>","<spouseDOB>","<spouseOccupation>","<spouseHeightFeet>","<spouseHeightInch>","<spouseWeight>"
    And  Enter Details  the child on the member details Screen "<childName>","<childdob>","<childHeightFeet>","<childHeightInch>","<childweight>"
    And  Enter details  medical question on medical screen
    And  Enter details on Nominee page
    And  Check the Declaration popup
    And  Move the POSP parent portal
    And  Click the Lead tab
    And  Verify Lead ID from UI and DB
    And  Click Continue button from Lead section
    And  Click proceed to payment page
    And  Navigate payment page and fill all mandatory entries


    Examples:
      |FullName|MobileNo|eldestmemberage|eldestchildage|city|panCard|address|contactEmail|emergencyMobile|dob|occupation|heightFeet|heightInch|weight|spouseName|spouseDOB|spouseOccupation|spouseHeightFeet|spouseHeightInch|spouseWeight|childName|childdob|childHeightFeet|childHeightInch|childweight|
      |Ankit sharma|7701906615|35    |       5          |Delhi |AYMPB1667K|Agra flat 45|test@gmail.com|9411073568 |01-01-1988|1|60    |8         |72    |Pooja k   |01-01-1993|5     |60               |4               |68          |Rahul Sharma  |02-02-2018|36  |4         |35    |
