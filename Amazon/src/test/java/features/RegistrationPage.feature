Feature: User can Registration them self

  Scenario Outline: User can Registration them self
    Given User in amazon homepage
    Then User can hover and click SignIn
    Then User can click create amazon account
    Then User can enter name "<name>" email "<email>" password "<password>" rePassword "<rePassword>"
    Then User can click create your amazon account
    Then User can verify Mgs

   Examples:
   |name| email|password|rePassword|
   |Kamal|mukul@gmail.com|km12345|km12345|
