Feature: Account SignIn

  Scenario: Account SignIn with valid credential
Given User is in chase Bank Home Page
Then user gets the title of the HomePage
When User can able to enter valid "Username" and "Password"
When User can click submit button
Then user gets the title of the page after logIn

