# ConferenceProject
This is an application that may be used to sell tickets to a conference that takes place over a period of three days.
The conference has 4 types of tickets:
● Day 1 - price 200 RON.
● Day 2 - price 250 RON.
● Day 3 - price 250 RON.
● All days - price 500 RON.

Every day there can be maximum MAX_CAPACITY people at the conference, and the sale of tickets is restricted. 
The application has 2 types of users: cashier and administrator. They have a part of LOGIN that has to be used for authentification.
The administrator performs the following operations:
● CRUD on tickets (changing the price of a ticket, changing the number of available tickets).
● CRUD on cashiers.
● Change the MAX_CAPACITY number.
● Report with the number of tickets sold by a cashier.
● Report on daily earnings.
● Report total receipts based on tickets sold.
The cashier is able to:
● Ticket Sale - created a .txt file on disk for each ticket, with ticket details.
● View the history of the tickets sold by him ordered by time + date (the last tickets sold being the first).
This is a desktop application developed using Java, having an architectural pattern based on layers and the information is kept in a databse, mySQL database. For accesing the information from the database was used a pattern known as Table Data Gateway. 
