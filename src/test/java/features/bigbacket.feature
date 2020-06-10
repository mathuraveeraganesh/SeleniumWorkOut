Feature: Big Backet

Scenario: My Basket take ScreenShot 

Given Launch the BigBacket URL  
Given mouse over on Shop by Category  
Given Go to FOODGRAINS, OIL & MASALA and RICE & RICE PRODUCTS  
Given Click on BOILED & STEAM RICE  
And Get the URL of the page and check eith with site navigation link(HOME > FOODGRAINS, OIL & MASALA> RICE & RICE PRODUCTS> BOILED & STEAM RICE)  
And Choose the Brand as bb Royal  
And Go to Ponni Boiled Rice and select 10kg bag from Dropdown  
And Add Toor/Arhar Dal 2kg and set Qty 2 from the list  
And click Address  
When Select CHennai as City, Alandur-600016,Chennai as Area and click Continue  
Then Mouse over on My Basket take a screen shot  
Then Click View Basket and Checkout  
Then Click the close button and close the browser