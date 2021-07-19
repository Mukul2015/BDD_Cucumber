Feature: Book A Flight in Delta Airline
 Background:
   Given :user in DeltaAirline HomePage
   Then :user can click Book button

  Scenario: Book a flight
    Then :user can select "JFK " as Departure
    Then :user can select "BOS" as Arrival
    Then :user can select Trip
    Then :user can select Departure Date
    Then :user can select Arrival Date
    Then :user can select number of Passenger
    Then :user can submit request
    Then :user can verify Compare Nearby Airports

  Scenario: Book a flight
    Then :user can select "AUS" as Departure2
    Then :user can select "BOS" as Arrival2
    Then :user can select Trip
    Then :user can select Departure Date
    Then :user can select Arrival Date
    Then :user can select number of Passenger
    Then :user can submit request
    Then :user can verify Compare Nearby Airports

  Scenario: Book a flight
    Then :user can select "BUR" as Departure3
    Then :user can select "AUS" as Arrival3
    Then :user can select Trip
    Then :user can select Departure Date
    Then :user can select Arrival Date
    Then :user can select number of Passenger
    Then :user can submit request
    Then :user can verify Compare Nearby Airports

