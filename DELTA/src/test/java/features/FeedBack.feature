Feature: User can provide their FeedBack
Background:
  Given :User can go to Delta Airline HomePage
  Then :User can click FeedBack Button

  Scenario:User can check FeedBack Button
    Then :User can provide feedback rate
    Then :User can select feedback type
    Then :User can provide feedback massage
    Then :User can submit feedback request

  Scenario:User can check FeedBack Button
    Then :User can provide feedback rate
    Then :User can select other feedback type
    Then :User can provide feedback massage
    Then :User can submit feedback request

  Scenario:User can check FeedBack Button
    Then :User can provide feedback rate
    Then :User can select checkInTrip feedback type
    Then :User can provide feedback massage
    Then :User can submit feedback request
