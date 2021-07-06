Feature: find pharmacy using United Health care webSide

  Scenario Outline:find a pharmacy
    Given :User in United Health Care HomePage
    Then :User can click find doctor Button
    Then :User can click pharmacy Button
    And :User can enter pharmacy Name "<PharmacyName>" and zip "<ZipCode>"
    Then :User can click search Button
#    Then :User can verify pharmacy
    Examples:
    |PharmacyName|ZipCode|
    |Queens drug |11373  |
    |cvs         |11373  |