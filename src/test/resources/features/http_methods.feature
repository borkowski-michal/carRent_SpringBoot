Feature: Testing a REST API

Scenario: Testing valid GET endpoint
Given url 'http://localhost:8080/carRent/home'
When method GET
Then status 200

