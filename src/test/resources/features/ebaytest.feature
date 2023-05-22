##Author: Deepa Kaur
  #Keywords Summary : Home page
@eBayTest
Feature: Ebay home page navigation

  Scenario: Testing navigation to gift cards page
    Given A user is on home page
    When User searches the following tab
      | search        |
      | Deals & Sales |
    And User selects the following option
      | option     |
      | Gift Cards |
    And User is navigated to following page
      | page       |
      | Gift Cards |

    When User selects all filter option
    And Filter form is displayed

    When user applies filter as following
      | min | max  | delivery     | sellers                  | location | show only                                       |
      | 500 | 1000 | free postage | Sellers with eBay Stores | 100      | Sale items, Deals & Savings, Accepts Best offer |

    And user clicks apply
    Then user is navigated to gifts and vouchers screen with results
