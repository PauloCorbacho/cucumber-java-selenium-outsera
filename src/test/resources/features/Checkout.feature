Feature: Checkout Flow
  As an e-commerce user
  I want to complete an order
  So I can receive my products

  Scenario: Complete product purchase
    Given I am logged into the system
    When I add product "Sauce Labs Backpack" to cart
    And I access the shopping cart
    And I begin the checkout process
    And I fill my information with:
      | firstName | Paulo     |
      | lastName  | Corbacho    |
      | zipCode   | 90210    |
    And I complete the purchase
    Then The purchase should be completed successfully
    And I should see the message "Thank you for your order!"