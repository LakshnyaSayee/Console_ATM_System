ATM Console System (Java)

A Java console-based ATM simulation that demonstrates Object-Oriented Programming (Encapsulation) and HashMap-based account management.

The system supports Admin and User operations such as deposit, withdraw, transfer, and balance checking through a menu-driven interface.
Features
Admin

Load cash into ATM

Check ATM balance

View total transactions

User

Create account

Login with account number and PIN

Deposit money

Withdraw money

Transfer money

Change PIN

Check balance

View account receipt
Technologies Used

Java

OOP (Encapsulation)

HashMap

Scanner (console input)
Project Structurehashatm.java        → Account class  
hashatmsystem.java  → Main ATM system
Data Storage

Accounts are stored using:
HashMap<Integer, hashatm>
Key: Account Number

Value: Account Object

This allows fast account lookup.
Concepts Used

Encapsulation

HashMap

Menu-driven console program

ATM system simulation
Future Improvements

Transaction history

Account security (PIN attempts)

Database/file storage
