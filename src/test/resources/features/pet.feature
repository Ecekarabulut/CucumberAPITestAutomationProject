Feature: Pet Store API Operations
  As a user
  I want to perform CRUD operations on pets
  So that I can manage pet information

  Background:
    Given I have a pet with the following details
      | name    | status   |
      | Max     | available|

  Scenario: Create a new pet
    When I create the pet
    Then the response status code should be 200
    And the pet should be created successfully

  Scenario: Get pet by ID
    Given I have created a pet
    When I get the pet by ID
    Then the response status code should be 200
    And the pet details should match the created pet

  Scenario: Update pet information
    Given I have created a pet
    When I update the pet name to "Max Updated"
    Then the response status code should be 200
    And the pet name should be updated to "Max Updated"