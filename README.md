# DigitalLibrarySystem
#Overview-
The Digital Library Book Management System is a simple Java-based console application designed to help librarians efficiently manage book records. The system enables users to add, view, search, update, and delete books from a catalog while maintaining their availability status.

 #Features-
📌 1. Add a Book
The user enters Book ID, Title, Author, Genre, and Availability Status.
The book is then stored in an ArrayList<Book>.
📌 2. View All Books
Displays a list of all available books with details.
📌 3. Search a Book
Users can search for a book using Book ID or Title.
If found, book details are displayed.
📌 4. Update a Book
Allows modification of a book’s title, author, genre, and availability status.
📌 5. Delete a Book
Removes a book from the catalog using Book ID.
📌 6. Exit System
Closes the program safely.

#How to Run the Project-
1.Compile the Java Program
javac LibrarySystem.java
2. Run the Program
java LibrarySystem

#Follow the On-Screen Instructions-
Upon running, a menu will be displayed allowing users to:
Add new books
View all books
Search for a specific book
Update book details
Delete a book
Exit the system

#Challenges Faced:
1.User Input Issues: If users entered wrong data, the program could crash.Added try-catch to fix this.

2.No Data Storage: Books are lost when the program closes.

#Future Improvements:
1. Save Data: Store books in a file or database so they are not lost.
2. Better UI: Add a graphical interface (GUI) for easy use.
3. More Error Handling: Prevent crashes and give clear error messages.

#Conclusion-
The Library System is a simple Java program to add, view, search, update, and delete books. It uses try-catch to handle errors, making it easy to use without crashes.
1.Easy to Use – Simple menu for managing books.
2.Error Handling – Prevents wrong inputs using try-catch.
3.Fast & Efficient – Uses lists and search functions for quick access.


