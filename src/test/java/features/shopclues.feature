Feature: Shop Clues

Scenario: Select Highest Price Shoe

Given Launch the Shopclues URL
And Mouseover on women and click Casual Shoes
And Select Color as Black
And Check whether the product name contains the word black
And Get the current page URL and check with the product ID
And Copy the offercode 
And Select size, color and click ADD TO CART
When Mouse over on Shopping cart and click View Cart 
Then Type Pincode as 600016 click Submit and Place Order
Then Close the Browser