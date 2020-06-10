Feature: Ajio

Scenario: Sort with Discount

Given Launch the Ajio URL
Given Mouseover on Women, CATEGORIES and click on Kurtas
And Click on Brands and choose Ajio
And Check all the results are Ajio
And Set Sort by the result as Discount
And Select the Color and click ADD TO BAG
And Verify the error message Select your size to know your estimated delivery date
And Select size and click ADD TO BAG
And click on Enter pin-code to know estimated delivery date
And Enter the pincode as 603103 and click Confirm pincode
When Print the message and click Go to  Bag
Then Click on Proceed to Shipping and clode the browser