Feature: User can SignIn
  Scenario Outline:User can SignIn
  Given User in Amazon homepage
    Then User can click signIn Button
    Then User can enter "<Email>" and continuePage
    Then User can enter "<password>"
    Then User can enter SignIn
    Then User can verify SignIn

    Examples:
    |Email|password|
    |mukul_wana@yahoo.com| km12345|