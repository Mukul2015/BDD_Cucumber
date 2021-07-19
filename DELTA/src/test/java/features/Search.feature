Feature:Search Delta Airline product

  Background:
    Given :user in Delta HomePage
    Then :user can click search button

  Scenario: User Can Search Delta Airline product
    Then :User Can enter "LGA" in searchBox
    Then :user can click searchField search button
    Then :user can click Flight Partners
    And :user can validate Friends

  Scenario: User Can Search Delta Airline product
    Then :User Can enter "JFK" in searchBox
    Then :user can click searchField search button
    Then :user can click NewYork Jfk
    And :user can validate NewYorkCity

  Scenario: User Can Search Delta Airline product
    Then :User Can enter "AUS" in searchBox
    Then :user can click searchField search button
    Then :user can click Cashless airport
    And :user can validate Cashless