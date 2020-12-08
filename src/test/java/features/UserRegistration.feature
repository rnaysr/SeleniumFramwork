Feature: User Registration
	I want to check that the user can register in our e-commerce website.
	
Scenario Outline: User Registration
Given User in home page
When  I click on register link
And I entered "<firstname>" , "<lastname>", "<email>" , "<password>"
Then The registration page displayed successfully

Examples:
	| firstname | lastname | email | password |
	| rana | diwan | t1@gmail.com | 12345678 |
	| moha | moha | t090@gmail.com | 98765432  |