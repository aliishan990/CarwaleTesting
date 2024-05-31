Feature: Seearching New Cars

  In order to search new car
  I have to navigate to carwala.com

  Scenario Outline: Finding new cars
    Given user navigates to carwala website
    When user mouseover to newcars
    And user clicks on findnewcars
    Then user clicks on "<carBrand>"  car
    And user validates cartitle as "<carTitle>"
    Examples:
      | carBrand | carTitle    |
      | Toyota   | Toyota Cars |
      | BMW      | BMW Cars    |
      | Audi     | Audi Cars   |
      | Kia      | Kia Carss   |

