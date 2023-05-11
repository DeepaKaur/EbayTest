##Author: Deepa Kaur
#  #Keywords Summary : Gift Card page
@GiftCard
Feature: Gift card page

  Scenario: Testing Gift Cards page to all filter option
    Given A user is on gift cards page
    When User selects all filter option
    Then Filter form is displayed

