Feature: User can select location

  Background:
    Given user in hotel HomePage
    Then user can click Location button

  Scenario: select hilton hotel
    Then user can select Asia zone
    Then user can select Indian Hotel
    Then user can select first one from the Indian Hotel list

  Scenario: select hilton hotel
    Then user can select North America zone
    Then user can select Alaska Hotel
    Then user can select first one from the Alaska Hotel list
