Feature: trivago 

Scenario: Room Reservation

Given Launch the Website 
Given Type Agra in Destination and select Agra, Uttar Pradesh.
And Choose May 15 as check in and June 30 as check out
And Select Room as Family Room
And Choose Number of Adults 2, Childern 1 and set Child's Age as 4
And Click Confirm button and click Search
And Select Accommodation type as Hotels only and choose 4 stars
And Select Guest rating as Very Good
And Set Hotel Location as Agra Fort and click Done
And In more Filters, select Air conditioning, Restaurant and WiFi and click Done
When Sort the result as Rating & Recommended
Then Print the Hotel name, Rating, Number of Reviews and Click View Deal
Then Print the URL of the Page
Then Print the Price of the Room and click Choose Your Room
Then Click Reserve and I'll Reserve
Then Close the browser
