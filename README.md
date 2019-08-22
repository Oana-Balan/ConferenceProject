# ConferenceProject
This is an application that may be used to sell tickets to a conference that takes place over a period of three days.
The conference has 4 types of tickets:
● Day 1 - price 200 RON.
● Day 2 - price 250 RON.
● Day 3 - price 250 RON.
● All days - price 500 RON.

Every day there can be maximum MAX_CAPACITY people at the conference, and the sale of tickets of this aspect will have to be restricted. 
The application has 2 types of users: cashier and administrator. They have a part of LOGIN that has to bw used for authentification.
The administratorvperforms the following operations:
● CRUD on tickets (changing the price of a ticket, changing the number of available tickets).
● CRUD on cashiers.
● Changed the MAX_CAPACITY number.
● Report with the number of tickets sold by a cashier.
● Report on daily earnings.
● Reported total receipts based on tickets sold.
The cashier is able to:
● Ticket Sale - created a .txt file on disk for each ticket, with ticket details.
● Viewing the history of the tickets sold by him ordered by time + date (the last tickets sold being the first).
This is a desktop application is Java, having a architectural pattern based on layers and the informations are kept in a databse, mySQL database. For accesing the informations from the database was used a pattern knowm as Table Data Gateway. 
