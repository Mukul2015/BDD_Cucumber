Feature: SignUp in Delta Airlines

  Scenario:User can SignUp
    Given User on Delta Airlines HomePage
    Then User can click SIGN UP Button
    Then User can select their Prefix
    Then User can fillUp firstName and lastName
    |firstName |lastName |
    |Monirul   |Islam    |
     Then User can select their Gender
#    Then User can fillUp their DOB month and day and year
    And User can select their Country
#    And User can select their AddressType
    And User can fillUp address and city and zipCode
    |address |city |zipCode |
    |4207 Elbertson St|Elmhurst|11373|
#    And User can select their CountryCode
    And User can fillUp AreaCode and PhoneNumber and Email and ConfirmEmail
    |AreaCode |PhoneNumber |Email |ConfirmEmail |
    |11373    |+19176094847  |mukul_wana@yahoo.com|mukul_wana@yahoo.com|
    And User can fillUp UserName and Password and ConfirmPassword
    |UserName |Password |ConfirmPassword |
    |mukul    |Urme2000 |Urme2000        |
    And User can select Question1
    And User can fillUp Answer1
#    And User can select Question2
#    And User can fillUp Answer2
#    And User can select their Language
#    And User can select their SkyMiles
#    And User can click Complete Button