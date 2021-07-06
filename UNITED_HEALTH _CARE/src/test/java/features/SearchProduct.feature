Feature: search a product in united health care
Scenario:search a product
Given :User in United Health Care HomePage
Then :User can search "NYC"
Then :User can click products
Then :User can click vision plan
Then :User can enter zipCode "25641"
Then :User can click search
And :User can validate massage