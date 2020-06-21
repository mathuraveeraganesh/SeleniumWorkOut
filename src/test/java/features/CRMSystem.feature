Feature: CRM System

Scenario: Meeting is assigned to the contact

 Given Launch the CRM System
And Give username as admin and password as admin
And  Choose theme as Claro Theme
And Go to Sales and Marketting and click Sales Home
And Click Create contact
And Select Title and type First name, Last Name, Email and Phone Numbers
And Select Lead Source as Public Relations and Business Roles
And Fill the Primary Address, City, State, Country and Postal Code and click Save
And Click create and Leads
And Fill First & Last name, Status as In Process, Title as Manager and Department as Sales
And Select Lead as Public Relations and fill department, Email and Phone Number
And Click Save and View
And Mouse over on Today's Activities and click Meetings
And Type Subject as Project Status Status as Planned and Time as tomorrow 3 p.m
And Click Add paricipants, add your created Lead name and click Save
When Click contacts under Sales and Marketting, search the lead Name and click the name from the result
Then Check weather the Meeting is assigned to the contact.