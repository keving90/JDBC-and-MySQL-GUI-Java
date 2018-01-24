# JDBC-and-MySQL-GUI-Java
Creates a MySQL database and connects to it through the JDBC API. 

This project creates a MySQL database and connects to it through the JDBC API. I learned how to create it by following a tutorial written by Radhika Grover for her *Java Programming, Comprehensive* course with UCSC Extension.

This project uses a Model, View, and Controller design pattern to create an interactive GUI that is connected to a MySQL database. Users can add, delete, or update records in the GUI’s table, and these modifications be done to the underlying database as well. After any modifications are done, the GUI will be updated to reflect the changes in the database. The GUI was created using NetBeans. The rest of the code was written using IntelliJ.

# Requirements

This program requires Java, MySQL, and JDBC. I used Java 8 and MySQL Community Server 5.7.18 to create this project. Connector/J is also needed for Java to work with MySQL. For more information, visit: https://dev.mysql.com/downloads/connector/j/

# Instructions

After everything has been installed you will need to create the database. Start MySQL in Terminal, and use `CREATE DATABASE test1;` to create a database called `test1`. You can then use the database with `use test1;`. After the database is in use, you can create the `courselist` table by running the `provision.sql` file. To do so, use: `SOURCE /PATH/TO/FILE/provision.sql`. The table should be created, and the data should now be present in the database. You can use `SELECT * FROM courselist;` to verify.

To run the Java program, you will need to edit `line 40` in `CourseListTableModel.java` so they match your username and password. If this is not done, then the program will not be able to connect to MySQL. After these steps have been done, you can compile and run the Java code. When the program begins, you should see a GUI with the database records displayed. You can add, delete, and update records.
