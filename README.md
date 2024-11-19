#Running the Application

Start the Backend Server
Ensure MySQL and Tomcat are running.
Access the server:
Open a browser and navigate to http://localhost:8080/
##Troubleshooting
###MySQL connection issues:

Verify that MySQL is running and the database credentials in hibernate.cfg.xml are correct.

###Backend server not starting:

Check the Tomcat logs in the logs/ folder for errors.

###Frontend not loading correctly:

Ensure the frontend files are deployed in the correct directory and the backend server URL is updated.

#CRUD Application Overview

This CRUD (Create, Read, Update, Delete) application is developed using Hibernate and Java Servlet, providing a robust and efficient platform for managing data within a database. It offers essential data management operations with a focus on reliability and scalability, making it ideal for enterprise-level applications.

##Key Features:

Create: Users can easily add new records to the database through intuitive forms, with Hibernate handling the persistence layer.

Read: Data is retrieved from the database and displayed in a user-friendly format, utilizing Java Servlet for seamless server-side processing.

Update: Existing records can be updated with ease, ensuring that the database remains accurate and current.

Delete: Users can remove unwanted records, with options for individual deletion or mass deletion of all records.


###Technology Stack:

Hibernate: Facilitates object-relational mapping (ORM), allowing for efficient interaction with the database and simplifying complex queries.
Java Servlet: Powers the server-side logic, handling client requests and responses, and ensuring smooth communication between the user interface and the database.


#User Interface:

The application features a responsive design that is compatible with various devices, including desktops and mobile devices. Entry fields for adding data are hidden by default, appearing only when the user clicks the 'Add' button, providing a clean and organized interface.

#Additional Functionality:

Delete All Records: A feature that allows users to remove all entries from the database at once, useful for resetting the application or performing bulk data cleanup.

This CRUD application is a comprehensive solution for managing data, leveraging the power of Hibernate and Java Servlet to deliver a reliable and scalable data management tool.
