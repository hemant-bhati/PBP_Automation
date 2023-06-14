@HealthCJ
Feature: Health Journey functionality
  Background: Login Application
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

#  Scenario Outline: validate the error msg while keeping name and mobile no as blank in Health page
#    When Click on Sell now modules
#    When Click on the Health buttons
#    And Enter the detail in Health landing page "<FullName>","<MobileNo>"
#    Then validate the error msg
#    Examples:
#      |FullName|MobileNo|
#      |||


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
      And verify the
      Examples:
      |FullName|MobileNo|eldestmemberage|city|panCard|address|contactEmail|emergencyMobile|dob|occupation|heightFeet|heightInch|weight|spouseName|spouseDOB|spouseOccupation|spouseHeightFeet|spouseHeightInch|spouseWeight|
      |Test Automation|9810168351|35    |Noida|AYMPB1667K|Delhi|test@gmail.com|9411073568 |01-01-1998|1|60    |8         |72    |Pooja k   |01-01-2002|5     |60               |4               |68          |

