@NivaGeneric
Feature: user is able to do the journey of niva
  Background: Login functionality
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

  Scenario Outline: user is able to run all the journey of niva
    When Click on sell now button
    When Click on Health Module
    And  Enter detail on Health page "<FullName>","<MobileNo>"
    Then user should be able to navigate to the member detail
    And  user should enter the details on member screen "<eldestmemberage>"
    And  User should be able to select the City Name "<city>"
    And  select existing illness and click on the View Plan checkbox
    And  Enter  the spouse age through edit member on the quote page
    And  click on the cover ammount dorp down button
    And  Select the 1cr suminsurred
    And  Click on the Apply button
    And  click on premium button of niva plan "<PlanName>","<PlanID>","<SumInsured>"And"<CityGroup_Id>"
    And  click on proceed to proposal Page after adding rider
    And  Enter details on the proposer details screen "<panCard>","<address>","<contactEmail>","<emergencyMobile>"
    And  Enter the Details on member details screen "<dob>","<occupation>","<heightFeet>","<heightInch>","<weight>","<spouseName>","<spouseDOB>","<spouseOccupation>","<spouseHeightFeet>","<spouseHeightInch>","<spouseWeight>"
    And  Enter the Details on medical screen
    And  Enter details on Nominee page
    And  Check the Declaration popup
    And  Move the POSP parent portal
    And  Click the Lead tab
    And  Verify Lead ID from UI and DB
    And  Click Continue button from Lead section
    And  Click proceed to payment page
    And  Navigate payment page and fill all mandatory entries


    Examples:
      |FullName|MobileNo|eldestmemberage|city|panCard|address|contactEmail|emergencyMobile|dob|occupation|heightFeet|heightInch|weight|spouseName|spouseDOB|spouseOccupation|spouseHeightFeet|spouseHeightInch|spouseWeight|PlanName|PlanID|SumInsured|CityGroup_Id|
      |Test Automation|7701906615|35    |Hyderabad|AYMPB1667K|B123|test@gmail.com|9411073568 |01-01-1998|1|60    |8         |72    |Pooja k   |01-01-2002|5     |60               |4               |68          |HealthReAssure|626  | 10000000         |118|
