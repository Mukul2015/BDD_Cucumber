Feature: Book A Flight in Delta Airline
  Scenario: Book a flight
    Given :user in DeltaAirline HomePage
    Then :user can click Book button
    Then :user can select "JFK" as Departure
    Then :user can select "BOS" as Arrival
    Then :user can select Trip
    Then :user can select Departure Date
    Then :user can select Arrival Date
    Then :user can select number of Passenger
    Then :user can click show fareButton
    Then :user can select best fare
    Then :user can submit request
    Then :user can verify Compare Nearby Airports
