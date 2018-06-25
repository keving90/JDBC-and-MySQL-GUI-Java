# JDBC-and-MySQL-GUI-Java
This project creates a MySQL database and connects to it through the JDBC API.

This project uses a Model, View, and Controller design pattern to create an interactive GUI that is connected to a MySQL database. Users can add, delete, or update records in the GUI’s table, and these modifications be done to the underlying database as well. After any modifications are done, the GUI will be updated to reflect the changes in the database. The GUI was created using NetBeans. The rest of the code was written using IntelliJ.

## Requirements

This program requires Java, MySQL, and JDBC. I used Java 8 and MySQL Community Server 5.7.18 to create this project. Connector/J is also needed for Java to work with MySQL. For more information, visit: https://dev.mysql.com/downloads/connector/j/

## Instructions

After everything has been installed you will need to create the database. Start MySQL in Terminal, and use `CREATE DATABASE test1;` to create a database called `test1`. You can then use the database with `USE test1;`. After the database is in use, you can create the `courselist` table by running the `provision.sql` file. To do so, use: `SOURCE /PATH/TO/FILE/provision.sql`. The table should be created, and the data should now be present in the database. You can use `SELECT * FROM courselist;` to verify.

To run the Java program, you will need to edit `line 40` in `CourseListTableModel.java` so they match your username and password. If this is not done, then the program will not be able to connect to MySQL. After these steps have been done, you can compile and run the Java code. When the program begins, you should see a GUI with the database records displayed. You can add, delete, and update records. **Running this program using NetBeans or IntelliJ is highly recommended.**

## Demonstration

The GUI is displayed when the program begins. Notice that when the user clicks on a row, the text fields are updated:

<img width="597" alt="screen shot 2018-01-23 at 5 41 32 pm" src="https://user-images.githubusercontent.com/30678180/35310136-c39523d0-0064-11e8-9251-c404259aa81b.png">

This data in the GUI matches the data in the MySQL database:

<img width="797" alt="screen shot 2018-01-23 at 5 41 32 pm" src="https://user-images.githubusercontent.com/30678180/35310256-5d8f9218-0065-11e8-8690-d298ed94729f.png">

We will now add a row. We fill in the text fields and click "Add". You can see that the new record has been added to the bottom of the table, and the database reflects the changes:

<img width="597" alt="screen shot 2018-01-23 at 5 41 32 pm" src="https://user-images.githubusercontent.com/30678180/35310417-21d56170-0066-11e8-92b3-38dc719e1c9a.png">

<img width="797" alt="screen shot 2018-01-23 at 5 41 32 pm" src="https://user-images.githubusercontent.com/30678180/35310352-d516d83c-0065-11e8-8bb0-8b96d8dad6c0.png">

We can update a row in the table by clicking on the row in the table, modifying the text field(s), and clicking update:

<img width="597" alt="screen shot 2018-01-23 at 5 41 32 pm" src="https://user-images.githubusercontent.com/30678180/35310672-61393fde-0067-11e8-8232-23bac1e1bc77.png">

<img width="797" alt="screen shot 2018-01-23 at 5 41 32 pm" src="https://user-images.githubusercontent.com/30678180/35310701-820f24ee-0067-11e8-8712-a9e3369ccf11.png">

Finally, we will delete the row by clicking on the row and clicking "Delete". The most recent deleted row's info will be shown in the text fields. I deleted two records here for the sake of the example:

<img width="597" alt="screen shot 2018-01-23 at 5 41 32 pm" src="https://user-images.githubusercontent.com/30678180/35310844-465a83a2-0068-11e8-9979-d7c00c433820.png">

<img width="797" alt="screen shot 2018-01-23 at 5 41 32 pm" src="https://user-images.githubusercontent.com/30678180/35310849-4bd9d95e-0068-11e8-989d-1e992718cf95.png">

## Issues Along the Way
I had trouble with the `CachedRowSet`'s cursor being out of position. This mainly happened when deleting a row. The issue was that the GUI was trying to update the table, and it was still trying to access the deleted row. Although the row would be deleted, a new row at the bottom of the table would form where each field in the row said `java.sql.SQLException: Invalid cursor position`. It was difficult to fix at first because the stack trace was not being displayed. When I was finally able to get it to display, I realized the problem was coming from the `getValueAt(int row, int col)` method in `CourseListTableModel.java`. The `absolute()` method inside `getValueAt()` was causing the cursor to be out of position when it tried to access the deleted row. My solution was to get the size of the new database table, and `return` the function if `row` was greater than or equal to the size of the table.

## Final Remarks
Please let me know if you are having trouble getting this program to work. Also, comments and suggestions are welcome. Thank you for looking at my project!
