Feature: User can register their self

  Scenario: User can register
    Given :User in Hilton hotel homePage
    Then :User can click join Button
    Then :User can enter "firstName" and "lastName"
#    Then :User can enter"3654889"
    Then :User can enter email"mukul_wana@yahoo.com"
    Then :User can select country
    Then :User can enter address and zip and city
    |address |zip |city|
    |4207 Elbertson St |11373 |newyork|
    Then :User can enter password and confirmPassword
    |password |confirmPassword|
    |mukul00 |confirmPassword|
    Then :User in click joinFree button
    Then :User can verify Error Massage