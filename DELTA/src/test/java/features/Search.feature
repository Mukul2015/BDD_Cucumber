Feature:Search Delta Airline product

  Scenario: User Can Search Delta Airline product

    Given :user in Delta HomePage
    Then :user can click search button
    Then :User Can enter "LGA" in searchBox
    Then :user can click searchField search button
    Then :user can click Flight Partners
    And :user can validate Friends