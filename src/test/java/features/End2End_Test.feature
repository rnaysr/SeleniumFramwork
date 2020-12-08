Feature: Automated End2End Tests
 Description: The purpose of this feature is to test End To End integration.
 Scenario Outline:
Given user is on Home Page
When User search for "<productName>"
And User choose to buy two items
And User moves to checkout cart and enter his personal details on checkout page and place the order
Then user can view the order and download the invoice 


Examples:
	
	| productName |
	| Apple MacBook Pro 13-inch |
	
	