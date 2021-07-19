Feature:User Can click account List all options

    Background:
    Given User in Amazon HomePage
    Then User can click  SignIn Button
    Then User can logIn with email "mukul_wana@yahoo.com"
    Then User can logIn with password "newyork117*"
    Then User hover AccountList Button

  Scenario: User Can click account List all options
  Then User can click Browsing History
  Then User can Verify Browser History mgs

  Scenario: User Can click account List all options
   Then User can click order button
   Then User can Verify your order mgs

  Scenario: User Can click account List all options
  Then User can click Account Button
  Then User can Verify Your Account mgs

  Scenario: User Can click account List all options
  Then User can click WatchList
  Then User can Verify Purchases & Rentals mgs

  Scenario: User Can click account List all options
  Then User can click Prime Membership
  Then User can verify free trial mgs

  Scenario: User Can click account List all options
  Then User can click Create a List
  Then User can Verify Shopping List mgs

  Scenario: User Can click account List all options
  Then User can click ContentDevices
  Then User can Verify ContentDevices mgs
