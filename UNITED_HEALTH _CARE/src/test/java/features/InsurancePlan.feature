Feature: User can select a Insurance plan from United health care

  Background:
    Given User in United Health care page
    Then User can click Insurance plan Button
  Scenario: select a Insurance plan
    Then User can click Medicare Button
    Then User can enter zipcode "11373"
    Then User can click find Medicare plan Button
    Then User can click medicare advantage plan Button
    Then User can click Get started Button
    And User can verify Medicare massage

  Scenario: select a Insurance plan
    Then User can click Medicare Button
    Then User can enter zipcode "11372"
    Then User can click find Medicare plan Button
    Then User can click medicare advantage plan Button
    Then User can click Get started Button
    And User can verify Medicare massage

  Scenario: select a Insurance plan
    Then User can click Medicaid Button
    Then User can enter zipcode "11375"
    Then User can click find Medicaid plan Button
    Then User can click MarketPlace
    Then User view plan Details
    And User can verify Medicaid massage