# Task Planner System

Implementation of a task planner system

##### A task has the following details :
    1. Title
    2. Creator
    3. Assignee (Optional)
    4. Status
    5. Type 
    6. Due date

##### A task can be of following types with additional information apart from what is mentioned above
    1. Feature
        a. Feature summary
        b. Impact (Low, Moderate, High)
    2. Bug
        a. Severity (P0, P1 or P2)
    3. Story
        a. Story Summary
        b. Story Points	

It should be easy to add a new task type to your application

* The status can change from a state to any state.
* Status field takes one of the following states depending on the task type :
	* Feature => Open, In progress, Testing, Deployed
	* Bug => Open, In progress, Fixed
	* Story => Open, In Progress, Completed


A sprint is defined as a collection of tasks used to track progress. You can add or remove a task from sprints.
A task can be part of only one sprint at a time.

##### Task planner have the following functionalities:
    1. Task
        a. Create a task of any type
        b. Change the status of the task
        c. Change assignee of the task
        d. Display tasks assigned to a particular user
    2. Sprint
        a. Create/Delete a Sprint
        b. Add/remove task to/from sprint
        c. Display sprint snapshot. This should display the tasks that are part of the sprint, their type, their assignee and the status

The transition/change in the status is based on allowed transitions
eg :-
##### For task type feature, we might want to have only following allowed transitions :
	Open => In progress
	In progress => Testing
	Testing => Deployed
	In progress  => Deployed


