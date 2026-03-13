Bookstore Management System – Distributed Checkout Application
Project developed within the Programming / Distributed Systems course

I designed and implemented an application for managing book sales in a bookstore, based on client–server architecture, which simulates multiple cash registers connected to a centralized system. I used it in the context of an exam from the winter session

Implemented functionalities:

entering the unique ID of the books for processing purchases

validating the codes entered and requesting re-entry if they do not exist in the system

generating the receipt with the name of the books, the unit price and the total value

automatic application of progressive discounts depending on the value of the purchases

support for multiple cash registers connected to the server simultaneously

querying the central system for:

list of all books sold

total value of sales

Architecture and implementation:

client–server communication via sockets

backend developed with Quarkus

data persistence via Hibernate and Java Persistence API

PostgreSQL database

dependency management with Apache Maven

Technologies used:
Java, Sockets, Client–Server Architecture, Quarkus, Hibernate ORM, JPA, PostgreSQL, Maven

Demonstrated skills:
Backend development, distributed systems, database integration, transaction processing, object-relational mapping, software architecture.
