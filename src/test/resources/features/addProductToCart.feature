Feature: Add product to cart

  Scenario:Add product to cart sucess
    Given that the user opens Falabella page and searches any product
    When the user selects one product from the list and clicks on it
    And the user selects three units of the product and click on the button cart
    Then The user will see the product name and the correct units added to the cart successfully