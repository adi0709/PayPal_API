Feature: Create an order using the PayPal API
  This is a feature to validate the creation of an order using PayPal API's

  Scenario Outline: Create an order using the Create Order API
    Given the use has the correct access token
    When the user hits the correct endpoint and provide the currencyCode as "<currencyCode>" and the amount as "<amount>"
    Then the order is created

    Examples:
      | currencyCode | amount |
      | USD          | 250    |