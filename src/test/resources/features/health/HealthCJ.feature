#Scenario:
#1)Gender - FeMale
#2)Combination - 2A
#3)City - Noida
#4)Cover - 3 lakh
#5)Plan - Health Pulse Enhanced
#6)Riders - Safeguard Benefit , Hospital Cash

@HealthPulseEnhanced
Feature: Health Journey functionality
  Background: Login Application
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons


    Scenario Outline: Verify User should be able to enter the details in Health page
      When Click on Sell now modules
      When Click on the Health buttons
      And Enter the detail in Health landing page "<FullName>","<MobileNo>"
      Then user should be able to navigate to member detail
      And user should enter the mandatory fields on member screen "<eldestmemberage>"
      And select City "<city>"
      And select existing illness and click on View Plan
      And Enter spouse age through edit member
      And click on premium button of NivaBupa
      And click on proceed to proposal page
      And Enter the details on proposer details screen "<panCard>","<address>","<contactEmail>","<emergencyMobile>"
      And Enter the details on member details screen "<dob>","<occupation>","<heightFeet>","<heightInch>","<weight>","<spouseName>","<spouseDOB>","<spouseOccupation>","<spouseHeightFeet>","<spouseHeightInch>","<spouseWeight>"
      And Enter the details on medical screen
      And Enter the details on Nominee page
      And check the Declaration popup
      And move to the POSP parent portal
      And click on the Lead tab
      And verify the Lead ID from UI and DB
      And click on Continue button from Lead section
      And click on proceed to payment page
      And navigate to payment page and fill all mandatory entries

      Examples:
      |FullName|MobileNo|eldestmemberage|city|panCard|address|contactEmail|emergencyMobile|dob|occupation|heightFeet|heightInch|weight|spouseName|spouseDOB|spouseOccupation|spouseHeightFeet|spouseHeightInch|spouseWeight|
      |Test Automation|9810168351|35    |Chandigarh|AYMPB1667K|Delhi|test@gmail.com|9411073568 |01-01-1998|1|60    |8         |72    |Pooja k   |01-01-2002|5     |60               |4               |68          |

#  Scenario: Niva Health Companion
#   1)Gender - Male
#   2)Combination - 2A+1K
#   3)City - Delhi
#   4)Cover - 7.5 lakh(Non-Pos)
#   5)Plan - Health Companion
#   6)Riders - Safeguard Benefit


@HealthCompanion
  Scenario Outline: Verify User should be able to enter the details in Health page
    When Click on Sell now modules
    When Click on the Health buttons
    And Enter the detail in Health page "<FullName>","<MobileNo>"
    Then user should be able to navigate to member detail
    And user should enter the details on member screen "<eldestmemberage>","<eldestchildage>"
    And select City Name "<city>"
    And select existing illness and click on View Plan
    And Enter spouse age through edit member on the quote page
    And Enter the ChildRelationship through the edit members
    And click on the cover ammount dorp down button
    And Select the  10 lakhs suminsurred
    And Click on the Apply button
    And click on premium button of healthcompanion of niva
    And click on proceed to proposal Page after adding rider
    And Enter the details on proposer details screen "<panCard>","<address>","<contactEmail>","<emergencyMobile>"
    And Enter the details of the member on member details screen "<dob>","<occupation>","<heightFeet>","<heightInch>","<weight>","<spouseName>","<spouseDOB>","<spouseOccupation>","<spouseHeightFeet>","<spouseHeightInch>","<spouseWeight>"
    And Enter the Details of the child on the member details Screen "<childName>","<childdob>","<childHeightFeet>","<childHeightInch>","<childweight>"
    And Enter the details of medical question on medical screen
    And Enter the details on Nominee page after medical page
    And check the Declaration popup
    And move to the POSP parent portal
    And click on the Lead tab
    And verify the Lead ID from UI and DB
    And click on Continue button from Lead section
    And click on proceed to payment page
    And navigate to payment page and fill all mandatory entries


    Examples:
      |FullName|MobileNo|eldestmemberage|eldestchildage|city|panCard|address|contactEmail|emergencyMobile|dob|occupation|heightFeet|heightInch|weight|spouseName|spouseDOB|spouseOccupation|spouseHeightFeet|spouseHeightInch|spouseWeight|childName|childdob|childHeightFeet|childHeightInch|childweight|
      |Ankit sharma|9810168351|35    |       5          |Delhi |AYMPB1667K|Agra flat 45|test@gmail.com|9411073568 |01-01-1988|1|60    |8         |72    |Pooja k   |01-01-1993|5     |60               |4               |68          |Rahul Sharma  |02-02-2018|36  |4         |35    |




