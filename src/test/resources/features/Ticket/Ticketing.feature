@Ticketing
Feature: Ticketing functionality
  Background: Login functionality
    When Enter the Partner Code
    Then Clicks on the send otp button in login page
    Then enter the generated otp numbers
    Then Click on verify otp buttons

    Scenario Outline:Generate ticketing functionality
      When Click on Tickets
      Then Click on New Tickets
      Then Click on Raise Tech issue
      Then Raise Mobile number change
#      Then Check for the validation message
      Then Mention change mobile number and Reason "<mobileNo2>","<remarks>"
      Then Click on submit button
      Then Copy the ticket ID
      Then Open the BMS portal
      Then Click on logout button from BMS
      Then Search the Copied Ticket ID
      Then click on edit button

#      When Click on Reports
#      Then click on Bookings
#      Then Click on product filter & choose CAR
#      Then Click on Raise Ticket icon

      Examples:
      |mobileNo2|remarks|
      |8984100|mobile no get change due to xyz|

