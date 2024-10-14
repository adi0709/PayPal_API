Feature: Get an order using the PayPal API
This is a feature to validate getting an order details using PayPal API

  Scenario Outline: Get the details of an order
    Given the use has the correct access token
    And the user hits the correct endpoint and provide the currencyCode as "USD" and the amount as "200"
    When the user provides the correct orderId and hit the endpoint
    Then the order details are displayed
