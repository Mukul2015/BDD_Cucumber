Feature: user can search a room in hilton hotel
  Scenario: Search a hotelRoom
    Given :User in Hilton hotel homePage
    Then :User can click on searchBox
    Then :User can enter cityName "NYC" and select
    Then :User can select city
    Then :User can select entry and exits date
    Then :User can select guest Number
    Then :User can select special Rate
    Then :User can click find Hotel