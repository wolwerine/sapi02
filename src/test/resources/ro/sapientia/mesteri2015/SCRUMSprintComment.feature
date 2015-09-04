Feature: Check if the story comments works
	As Sapientia scrum tool user I want to be able to add a comment to a story

   Scenario: AddComment
   Given I add a comment to the scrum list's first story
   When I enter "firstcomment" in  the title textbox and I push the add comment button
   Then I should get result "feedback.message.comment.added" in comment list
   
   
   