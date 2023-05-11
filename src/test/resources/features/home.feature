##Author: Deepa Kaur
  #Keywords Summary : Home page
@Home
Feature: Ebay home page navigation

  Scenario: Testing navigation to gift cards page
    Given A user is on home page
    When User searches the following tab
      | search |
      |Deals & Sales|
  And User selects the following option
      |option|
     |Gift Cards|
  Then User is navigated to following page
     | page |
     |Gift Cards|


