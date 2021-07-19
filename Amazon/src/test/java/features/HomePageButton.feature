Feature: User can click all Home page Button
  Background:
    Given User in Amazon homePage
  @IntegrationTest
  Scenario: User can click all Home page Button
    Then User Can check Amazon Logo in Homepage is present or not
  @IntegrationTest
  Scenario: User can click all Home page Button
    Then User can click Best Seller Button
    Then User can validate Amazon Best Sellers Mgs
  @IntegrationTest
  Scenario: User can click all Home page Button
    Then User can click today Dells Button
    Then User can validate pharmacy Mgs
  @RegressionTest
  Scenario: User can click all Home page Button
    Then User can click customer Service Button
    Then User can validate customer Service Mgs
  @IntegrationTest
  Scenario: User can click all Home page Button
    Then User can click new Release Button
    Then User can validate new Release Mgs
  @RegressionTest
  Scenario: User can click all Home page Button
    Then User can click books Button
    Then User can validate books Mgs
  @SmokeTest
  Scenario: User can click all Home page Button
    Then User can click fashion Button
    Then User can validate fashion Mgs
  @RegressionTest
  Scenario: User can click all Home page Button
    Then User can click kindleBook Button
  @SmokeTest
  Scenario: User can click all Home page Button
    Then User can click gift Button
    Then User can validate gift Mgs
  @SmokeTest
  Scenario: User can click all Home page Button
    Then User can click toys Button
    Then User can validate toys Mgs
