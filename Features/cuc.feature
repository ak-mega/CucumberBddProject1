Feature: Successfully login with valid input credentials
@Sanity 
Scenario: user successful login with valid input

Given user launch the webbrowser
When user open url "https://magento.softwaretestingboard.com/"
And user enter the usernam  "akshukla.shukla2@gmail.com" and password  "Admin123" 
And click on login button
Then page title should be "Home Page"
When user click on logout button
And close browser 

@regression
Scenario Outline: user successful login with valid input

Given user launch the webbrowser
When user open url "https://magento.softwaretestingboard.com/"
And user enter the usernam  "<email>" and password  "<password>" 
And click on login button
Then page title should be "Home Page"
When user click on logout button
And close browser

Examples:
|email|password|
|akshukla.shukla2@gmail.com|Admin123|

