#@ScenarioOutline
#
#Feature: Health Journey functionality from scenario Outline
#  Background: Login functionality
#    When Enter the URLs
#    When Enter the Partner Code
#    Then Clicks on the send otp button in login page
#    Then enter the generated otp numbers
#    Then Click on verify otp buttons
#
#
#  Scenario Outline: Health journey Functionality
#    Given Click on the Health button
#    Then Enter the details Health landing page "<fullName>","<phoneNo>"
#    Then select combination and age
#    Then Enter the State
#    Then Choose Existing illness
#    Then choose quote from the list
#    Then click on proceed to proposal
#    Then Fill Proposal form
#    Then fill member details
#    Then choose medical questions
#    Then fill the nominee section
#    Then Accept declaration pop-up
#    Examples:
#    |fullName|phoneNo|OTP2|OTP3|OTP4|OTP5|OTP6|
#    |Neha gupta|7877867890 |0   |1   |0   |1   |0   |
#
#
#  Scenario Outline: Health journey Functionality
#    Given Click on the Health button
#    Then Enter the details Health landing page
#    Then select combination and age
#    Then Enter the State
#    Then Choose Existing illness
#    Then choose quote from the list
#    Then click on proceed to proposal
#    Then Fill Proposal form
#    Then fill member details
#    Then choose medical questions
#    Then fill the nominee section
#    Then Accept declaration pop-up
#    Examples:
#      |partnercode|OTP1|OTP2|OTP3|OTP4|OTP5|OTP6|
#      |IP9022|1 |0   |1   |0   |1   |0   |
#
##  Scenario Outline: Health journey Functionality
##   When Enter the URLs
##    When Enter the Partner Code "<partnercode>"
##    Then Clicks on the send otp button in login page
##    Then enter the generated otp numbers "<OTP1>", "<OTP2>","<OTP3>","<OTP4>","<OTP5>","<OTP6>"
##    Then Click on verify otp buttons
##    Given Click on the Health button
##    Then Verify the title of Health journey landing page
##    Then Enter the details Health landing page
##    Then select combination and age
##    Then Enter the State
##    Then Choose Existing illness
##    Then choose quote from the list
##    Then click on proceed to proposal
##    Then Fill Proposal form
##    Then fill member details
##    Then choose medical questions
##    Then fill the nominee section
##    Then Accept declaration pop-up
##    Examples:
##      |partnercode|OTP1|OTP2|OTP3|OTP4|OTP5|OTP6|
##      |IP9022|1 |0   |1   |0   |1   |0   |
