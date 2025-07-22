Feature: Checkout Flow
  Scenario: Complete product purchase
    Given I am on the login page
    And I login with valid credentials
    When I add product "Sauce Labs Backpack" to cart
    And I access the shopping cart
    Then the cart should contain exactly 1 "Sauce Labs Backpack" with price "$29.99"
    And the item description should contain "carry.allTheThings()"
    And all cart buttons should be visible
    When I begin the checkout process
    And I fill my information with:
      | firstName | Paulo     |
      | lastName  | Corbacho  |
      | zipCode   | 90210     |
    And I complete the purchase
    Then The purchase should be completed successfully
    And I should see the message "Thank you for your order!"