# Bug Jar

*This is a migration of the current [monolithic](https://github.com/Gaatvul/Bug-Jar) architecture to microservices. This project will eventually be hosted on AWS Fargate using Docker.*

----------

### A fullstack reporting tool for software defects

Bug Jar allows for the reporting of issues encountered in a software application in addition to tracking the lifecycle of the issue. The application features the use of user accounts and roles and the ability to assign both a user and an owner to each issue. Users with the administrator role have access to every other account on the application and can modify details such as name, team, and role. The application also features an account management page for changing details such as name, email address and password