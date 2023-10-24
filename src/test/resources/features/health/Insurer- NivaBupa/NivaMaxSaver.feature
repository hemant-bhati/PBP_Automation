#Scenario: Max Saver
#1)Gender - Male
#2)Combination - 2A
#3)City - Mumbai
#4)Cover - 1cr (Non-POS)
#5)Plan - Max Saver
#6)Riders - Safeguard Benefit , Hospital Cash

@MaxSaver
Feature: Health Journey functionality
  Background: Login Application
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

   Scenario Outline: Verify User should be able to enter the details in Health page
     When Click on Sell now modules icon
     When Click on the Health buttons icon
     And Enter the detail in Health preQuotes page "<FullName>","<MobileNo>"
     Then user should be able to navigate to member detail page
     And user should be enter the mandatory fields on member screen "<eldestmemberage>"
     And select City name"<city>"
     And select existing illness & click on View Plan
     And Enter spouse Age through edit member
     And click on the cover amount dorp down button on the quote page
     And Select the  1 crore suminsurred
     And Click on the Apply button of cover amount drop down
     And click on the Insurer name dropdown button and select the name of the insurer
     And click on premium button of niva Max Saver
     And click on proceed to the proposal page
     And Enter the details on proposer details on the screen "<panCard>","<address>","<contactEmail>","<emergencyMobile>"
     And Enter the details on the member details screen "<dob>","<occupation>","<heightFeet>","<heightInch>","<weight>","<spouseName>","<spouseDOB>","<spouseOccupation>","<spouseHeightFeet>","<spouseHeightInch>","<spouseWeight>"
     And Enter the details on the medical screen
     And Enter the details on the Nominee page
     And Enter the Policy Expire Date for the policy port "<PolicyExpirydate>"
     And Enter the Details on the Portability page "<PolicyNumber>","<SumInsurred>","<CumulativeBonus>","<PEDDeclared>"
     And check to the Declaration popup
     And move to POSP parent portal
     And click on the Lead tab page
     And verify the to Lead ID from UI and DB
     And click on the Continue button from Lead section
     And click on the proceed to payment page
     And navigate to the payment page and fill all mandatory entries

     Examples:
       |FullName|MobileNo|eldestmemberage|city|panCard|address|contactEmail|emergencyMobile|dob|occupation|heightFeet|heightInch|weight|spouseName|spouseDOB|spouseOccupation|spouseHeightFeet|spouseHeightInch|spouseWeight|PolicyExpirydate|PolicyNumber|SumInsurred|CumulativeBonus|PEDDeclared|
       |Rahul Sharma|7701906615|40    |Mumbai|AYMPB1667K|Mumbai|test@gmail.com|9411073568 |01-01-1983|1|60    |8         |72    |Sonam Sharma   |01-01-1993|5     |60               |4               |68          |24-11-2023                |1010101010101|      1000000    |  500000 |Abc123456|

