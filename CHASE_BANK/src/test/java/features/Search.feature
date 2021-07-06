
Feature: Search chase Bank different types of loan product

 Background:
   Given User can go to  chase Bank homePage
   Then User can able to click search Button
   Then User can able to submit Search request

  Scenario: Search home loan
    Then User can able to enter HomeLoan in  search field
    And User can able to click on Understanding your loan options
    When User can verify Mortgage options page title

#  Scenario: Search Student loan
#    Then User can able to enter StudentLoan in  search field
#    And User can able to click on Chase Student Hub
#    When User can verify Get set for every step page title
#
#  Scenario: Search Car loan
#    Then User can able to enter CarLoan in  search field
#    And User can able to click on MyCar
#    When User can verify resource just for you page title
