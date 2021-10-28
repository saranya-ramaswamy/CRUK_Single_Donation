#Author: Saranya
#Date : 26 oct 2021

Feature: Feature to test Donation page of cancer research Donation

  @PositveTest
  Scenario: Validate One of Donation Amount button
    Given Cancer research single donation page is opened in chrome browser
    When page title is validated
    And user see the Amounts and selects Amount Ten
    Then validate if the amount is selected 
    And close the browser  
    
    @NegativeTest
    Scenario: Validate other amount textbox
    Given Cancer research single donation page is opened in chrome browser
    
    When page title is validated
    And user see textbox to enter an amount and Enter Negative value
    Then user receive a error message  
    And close the browser  
    
    
      
    
    