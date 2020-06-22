Feature: Honda

Scenario: Compare the Vehicle

Given Launch the Honda URL
And Click on scooters and click dio
And Click on Specifications and mouseover on Engine
And Put all the details as key and value into Map
And Go to Scooters and click Activa 125
And Put All its Engine Specification into another Map same as like dio
And Compare Dio and Activa Maps and print the different values of the samekeys.
And Click FAQ from Menu and Click dio under Browse By Product
And Click  Vehicle Price and Select scooter, Dio BS-VI from the dropdown and click submit
And click the price link,  Go to the new Window and select the state, city
And Print the price and model 
When Click Product Enquiry and Fill all the * field except Mobile, check the terms and conditions box and click submit
Then Verify the error message under the mobile number field.
Then Close the Honda Browser