Feature: Registration a user in United Health Care
Scenario Outline: Registration a user their data
  Given :User in United Health Care HomePage
  Then :User can click SignIn Button
  Then :User can click Medicare Plan
  Then :User can click Register Button
  Then :User can enter "<FirstName>" and "<LastName>"
  Then :User can enter "<DOB>" and "<zipCode>" and "<PlanID>"
  Then :User can  click submitButton

  Examples:
  |FirstName|LastName|DOB|zipCode|PlanID|
  |Monirul|Islam|07-05-1988|11373|856752566-88|
  |jamal|hamid|10/11/1988|11373|856752558-88|