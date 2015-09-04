Feature: Check if the story comments works
	As Sapientia scrum tool user I want to be able to update a comment to a story

   Scenario: UpdateComment
   Given I open the first comment on the scrum list's first story
   When I enter "firstcomment-update" in  the title textbox and I push the update comment button
   Then I should get result "feedback.message.comment.updated" in comments list
   
   
   