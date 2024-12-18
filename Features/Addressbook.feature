Feature: Address Book
@regression 
Scenario: Add new details

Given user launch the webbrowser
When user open url "https://magento.softwaretestingboard.com/"
And user enter the usernam  "akshukla.shukla2@gmail.com" and password  "Admin123" 
And click on login button
Then user can view dashboard
When user click on my account option
And click on Address book
Then user can view add address book details as title "Add New Address"
When user enter address information
And click on save address
Then user can view confirmation message as "You saved the address."
And close browser  
