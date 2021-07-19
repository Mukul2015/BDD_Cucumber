Feature: User can SignIn
  Scenario:User can SignIn
  Given User in Amazon homepage
    Then User can click signIn Button
    Then User can enter Email and continuePage and enter password
      |Email|password|
      |mukul_wana@yahoo.com| km12345|
    Then User can enter SignIn
    Then User can verify SignIn

