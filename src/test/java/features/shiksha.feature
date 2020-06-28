Feature: Shiksha

Scenario: Search the College with Low fees

Given Launch the Shiksha WebSite
And Mouse over on Colleges and click MS in Computer Science &Engg under MS Colleges
And Click Change course country select box, choose course as BE or Btech and Choose specialization as Computer Science & Engineering
And In Filters Select IELTS and score as 7.5 & Below in Exam Accepted
And Total Fees as Max 20L
And Capture the college Names and fees only if it is Engineering  course 
And Take 20 colleges by Click Next button and go to next page.
When Search the college name in the search box based on low fees
Then Match the IELTS score, course Title and country from the University Page