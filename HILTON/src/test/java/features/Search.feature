Feature: user can search a room in hilton hotel
  Background:
    Given :User in Hilton hotel homePage
    Then :User can click on searchBox

  Scenario: Search a hotelRoom
    Then :User can enter cityName "NYC" and select
    Then :User can select city
    Then :User can select entry and exits date
    Then :User can select guest Number
    Then :User can select special Rate
    Then :User can click find Hotel

  Scenario: Search a hotelRoom
    Then :User can enter cityName "TX" and select
    Then :User can select  Texas city
    Then :User can select entry and exits date
    Then :User can select guest Number
    Then :User can select special Rate
    Then :User can click find Hotel