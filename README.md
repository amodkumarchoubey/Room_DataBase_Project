# Room_DataBase_Project


What is Room?
The Room persistence library provides an abstraction layer over SQLite to allow for more robust database access while harnessing the full power of SQLite.
Basically, with the help of room we can quickly create sqlite databases and perform the operations like create, read, update and delete. Room makes everything very easy and quick.
Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite. 
Room is now considered as a better approach for data persistence than SQLiteDatabase. It makes it easier to work with SQLiteDatabase objects in your app, decreasing the amount of boilerplate code and verifying SQL queries at compile time.
Components of Room
We have 3 components of room.
1.	Entity: Instead of creating the SQLite table, we will create the Entity. Entity is nothing but a model class annotated with @Entity. The variables of this class is our columns, and the class is our table.
2.	Database: It is an abstract class where we define all our entities.
3.	DAO: Stands for Data Access Object. It is an interface that defines all the operations that we need to perform in our database.

Difference between SQLite and Room persistence library:-
•	In the case of SQLite, There is no compile-time verification of raw SQLite queries. But in Room, there is SQL validation at compile time.
•	You need to use lots of boilerplate code to convert between SQL queries and Java data objects. But, Room maps our database objects to Java Object without boilerplate code.
•	As your schema changes, you need to update the affected SQL queries manually. Room solves this problem.
•	Room is built to work with LiveData and RxJava for data observation, while SQLite does not. 


 
