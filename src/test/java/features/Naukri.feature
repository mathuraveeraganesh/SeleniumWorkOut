Feature: Naukri

Scenario: Upload random Image Get ErrorMessage

Given Open naukri.com
And Get the company names from each pop up window and close it
When Now, click on the upload cv button and upload some random image.
Then Get the error message printed