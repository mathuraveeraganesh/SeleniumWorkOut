Feature: carwale




Scenario: Low To High Match

Given Launch the URL
Given Click on Used
Given Select the City as Chennai
And Select budget min-8L and max-12L and Click Search
And Select Cars with Photos under Only Show Cars With
And Select Manufacturer as Hyundai --> Creta
And Select Fuel Type as Petrol
And Select Best Match as KM: Low to High
And Validate the Cars are listed with KMs Low to High
And Add the least KM ran car to Wishlist
And Go to Wishlist and Click on More Details
When  Print all the details under Overview in the Same way as displayed in application 
Then Close the browser.