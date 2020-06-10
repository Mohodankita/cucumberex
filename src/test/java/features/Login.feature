Feature: Application Login 


Scenario Outline: Home page default login 

	Given User is on login page 
	When User login into application with username "<User_Name>" 
	And User login into application with password "<Password>"
	
	
 Examples:
|User_Name|Password|
|kiran@gmail.com|123456|
	
#	Scenario: Home page default login 
#	Given User is on NetBanking landing page 
#	When User login into application with username "jonh" and password "4321"
#	Then Home page is populated 
#	And Cards are displayed "false"

 
	
