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



config | package ________________________
-------|-----
MyConfig | config class
WebMvcConfig | config class
WebSecurityConfig | config class

controller | package_________________
-----------|---------
CommentController | interface
CommentControllerImpl | class
GameController | interface
GameControllerImpl | class
GameObjectController | interface
GameObjectControllerImpl | class
UserController | interface
UserControllerImpl | class

dto | package ________________
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

email | package _________________________
-------|--------
EmailConfig | class
EmailProperty | class
EmailService | interface
MockEmailService | class
RealEmailService | class

entity | package_______________________________
-------|---------
Comment | Entity
Game | Entity
GameObject | Entity
Role | enum
User | Entity

exceptions | package________
-----------|----------
CommentGlobalExceptionHandler | class
NoSuchException | exception class

repository | package  _____________________
-----------|---------
CommentRepository | repository
GameObjectRepository | repository
GameRepository | repository
UserRepository | repository

service | package ____________________
--------|-------
CommentService | interface
CommentServiceImpl | class
GameObjectService | interface
GameObjectServiceImpl | class
GameService | interface
GameServiceImpl | class
UserService | interface
UserService | class

db.changelog | package_________________
-------------|--------
db.changelog-master.yaml | liquibase file

images | package _______________________________________
-------| -------
DB1.jpg | DB structure


DealersApplication | start app__________
-------------------|---------
application.properties | file properties
liquibase-maven-plugin.properties | file liquibase
estimate.md | work plan
pom.xml | settings file
README.md | this file

test | package _______________________
------|--------
GameServiceImplTest | Test class
DealersApplicationTests | Test class

REQUIREMENTS

The minimum requirement for starting Dealers is your PC have Windows 10

In the final version there is no restriction for the user, only a browser is required

**Instructions**

**Option 1**

Registration

1) The user enters the address localhost:8080/auth/register and leaves his data in the registration form:

 "first_name": "Vasia",

"last_name": "Pupkin",

"password": "111",

"email": "pupkin@mail.ru"

2) He receives an email with a link, upon passing to which he completes the registration at the same address

**Option 2**

User forgot password

1) User goes to the address ../auth/forgot_password and sends it in the form of an email
   . Then he receives a letter with a link to which he follows, confirming his identity.
   
2) After that, the user goes to the address ../auth/reset enters the data into the form:
   
   "code": "fa6b257b-52b3-4718-a240-9366e4d337b5",
   
   "password":999
   
   Congratulations !!! User changed the password!!

**Option 3**

Check code

1) You can also check the relevance of your code by reference ../auth/check_code/{code} by entering the code instead {code}


**Option 4**

**STATISTICS**

**Option 1**

**Statistics of Traders :**

1) Creating reviews for traders game objects : /articles/{userId}/comments
   
   "message": "TEST",
   
   "rating": 100,
   
   "gameObjectId":7

   
2) Сalculating the trader's rating : /object/{id}/rating

3) Сalculation of the general top traders based on their ratings of objects: /objects/top
   
 ** Option 2**

**Statistics for games**

1) Filter for maximum ratings of games : /games/rating/max
2) Filter for minimum ratings of games : /games/rating/min


   **Other EndPoints For you:**

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










