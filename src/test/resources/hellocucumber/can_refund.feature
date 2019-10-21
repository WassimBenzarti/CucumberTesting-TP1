#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Refund
	In case a user wants a refund
  
	Background:
		Given I purchased something 10 days ago for 5DT

  @tag1
  Scenario: Can I get a refund ?
    Given I have a receipt
    When I ask for a refund
    Then Increment the number of items in stock
    And Give 5DT back to me

	Scenario: Can I get a refund without a receipt ?
    Given I don't have a receipt
    And I have a proof of purchase
    When I ask for a refund
    Then Increment the number of items in stock
    And Give 5DT back to me
    
  Scenario: Can I get a refund without a receipt nor a proof ?
    Given I don't have a receipt
    And I have no proof of purchase
    When I ask for a refund
    Then Refuse refund

