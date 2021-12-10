# Application Dealers
Statistic of Game Objects Traders

Thank you for choosing our Application Dealers! 

This product can help you to create your own website based on this one.

We created all base methods to get statistics about game objects!

**Benefits:**

Ability to calculate statistics for both game objects, and their creators

The ability to connect to any software products thanks to HTTP requests

You can use this version with any version of the database


**INSTALLATION**
When you download this file, you will see next files and directories:



config | package
-------|-----
MyConfig | config class
WebMvcConfig | config class
WebSecurityConfig | config class

controller | package
-----------|---------
CommentController | interface
CommentControllerImpl | class
GameController | interface
GameControllerImpl | class
GameObjectController | interface
GameObjectControllerImpl | class
UserController | interface
UserControllerImpl | class

dto | package
----|---------
AddGameRequest | DTO
AddUserRequest | DTO
AdminResponseDto | DTO
CheckCodeResponse | DTO
CommentIncorrectData | DTO
CommentRequest | DTO
FilterResultGameDto | DTO
ForgotPasswordRequest | DTO
GameObjectRequest | DTO
LinkResponse | DTO
ListCommentResponse | DTO
ListGameObjectResponse | DTO
ListGameResponse | DTO
ListUserResponse | DTO
RatingDto | DTO
RatingResultForTradersDto | DTO
RegistrationResponse | DTO
ResetRequest | DTO

email | package
-------|--------
EmailConfig | class
EmailProperty | class
EmailService | interface
MockEmailService | class
RealEmailService | class

entity | package
-------|---------
Comment | Entity
Game | Entity
GameObject | Entity
Role | enum
User | Entity

exceptions | package
-----------|----------
CommentGlobalExceptionHandler | class
NoSuchException | exception class

repository | package
-----------|---------
CommentRepository | repository
GameObjectRepository | repository
GameRepository | repository
UserRepository | repository

service | package
--------|-------
CommentService | interface
CommentServiceImpl | class
GameObjectService | interface
GameObjectServiceImpl | class
GameService | interface
GameServiceImpl | class
UserService | interface
UserService | class

db.changelog | package
-------------|--------
db.changelog-master.yaml | liquibase file

images | package
-------| -------
DB1.jpg | DB structure


DealersApplication | start app
-------------------|---------
application.properties | file properties
liquibase-maven-plugin.properties | file liquibase
estimate.md | work plan
pom.xml | settings file
README.md | this file

test | package
------|--------
GameServiceImplTest | Test class
DealersApplicationTests | Test class

REQUIREMENTS

The minimum requirement for starting Dealers is your PC have Windows 10

In the final version there is no restriction for the user, only a browser is required

**EndPoints For you:**

 Path | Description
------------|-----------------------
/articles/{userId}/comments | POST request - add new comment
/users/{userId}/comments/{commentId} | GET request - view comment
/objects/{id}/comments | GET request - get all comment about object
/users/{userId}/comments | GET request - get comments by user id
/comments | GET request - view all comments
/users/{userId}/comments/{commentId} | DELETE request 
/articles/{id}/comments | PUT request - update
/games | GET request - get all games
/games | POST request - add game
/games/{id} | PUT request - update game
/games/rating/min | GET request - get rating games by min
/games/rating/max | GET request - get rating games by max
/objects | GET request - find all game objects
/object/{id} | PUT request - edit game object
/object | POST request - add game object
/object/{id} | DELETE request - delete game object
/object/{id}/rating | GET request - get rating of game object
/objects/top | GET request  - get rating traders
/object/user/{id} | GET request - find objects by trader
/object/game/{id} | GET request - find all objects by game
/register | POST request - registration/send link/continue registration
/confirm/{code} | GET request - confirm registration by link
/forgot_password | POST request - user send email for getting code
/check_code/{code} | GET request - check code from user
/reset | POST request - change password










