Narrative:
In order to access the AC Superstars Application
As an employee
I want to authenticate into the system


Scenario: Valid authentication for an user
Given I am on SignInPage
When I authenticate using default_username and default_password
Then I should be on HomePage

Scenario: Authentication with incomplete profile
Given I am on SignInPage
When I authenticate using default_username and default_password
Then I should be on HomePage
And I should see CompleteProfileModal