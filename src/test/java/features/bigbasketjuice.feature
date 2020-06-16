Feature: Big Basket Beverages

Scenario: Select Fruit juices & Drinks

Given Launch BigBasket Juices URL
And mouse over on  Shop by Category 
And click Tropicana and Real under Brand
And Check count of the products from each Brands and total count
And click on Change Address 
When Select CHennai as City, Alandur-600016,Chennai as Area  and click Continue
Then Mouse over on My Basket print the product name. count and price.
Then Click View Basker and Checkout
Then Click the Small close button and close the browser
