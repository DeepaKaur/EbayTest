#Author: Deepa Kaur
  #Keywords Summary : FilterAll form
@FilterAll
Feature: FilterAll Form

  Scenario: Testing item selection

    Given user is on all filter form on gift and vouchers
    When user applies filter as following
      | min | max | delivery | sellers | location | show only|
      | 500 | 1000 | free postage | Sellers with eBay Stores | 100 | Sale items, Deals & Savings, Accepts Best offer|

    And user clicks apply
    Then user is navigated to gifts and vouchers screen with results


