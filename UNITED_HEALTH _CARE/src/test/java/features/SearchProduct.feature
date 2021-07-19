Feature: search a product in united health care
  Background:
    Given :User in United Health Care HomePage
Scenario:search a product
Then :User can search "NYC"
Then :User can click products
Then :User can click vision plan
Then :User can enter zipCode "25641"
Then :User can click search
And :User can validate massage

  Scenario:search a product
Then :User can search "TX"
Then :User can click health insurance plans texas
Then :User can click Short term health insurance plan
And :User can validate massage texas