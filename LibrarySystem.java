import java.util.*;

class Book {
    String id, title, author, genre, status;

    Book(String id, String title, String author, String genre, String status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.status = status;
    }

    public String toString() {
        return id + " | " + title + " | " + author + " | " + genre + " | " + status;
    }
}

public class LibrarySystem {
    static Scanner sc = new Scanner(System.in);
    static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            try {
                System.out.println("\n1. Add  2. View  3. Search  4. Update  5. Delete  6. Exit");
                System.out.print("Enter choice: ");
                switch (Integer.parseInt(sc.nextLine().trim())) {
                    case 1 -> addBook();
                    case 2 -> viewBooks();
                    case 3 -> searchBook();
                    case 4 -> updateBook();
                    case 5 -> deleteBook();
                    case 6 -> { System.out.println("Exiting..."); return; }
                    default -> System.out.println("Invalid choice! Enter a number between 1-6.");
                }
            } catch (Exception e) {
                System.out.println("Error! Please enter a valid number.");
            }
        }
    }

    static void addBook() {
        try {
            System.out.print("Enter ID: ");
            String id = sc.nextLine().trim();
            if (id.isEmpty() || bookExists(id)) throw new Exception("Invalid or duplicate ID!");

            System.out.print("Enter Title: ");
            String title = sc.nextLine().trim();
            System.out.print("Enter Author: ");
            String author = sc.nextLine().trim();
            System.out.print("Enter Genre: ");
            String genre = sc.nextLine().trim();
            System.out.print("Enter Status (Available/Checked Out): ");
            String status = sc.nextLine().trim();

            if (title.isEmpty() || author.isEmpty() || genre.isEmpty() || status.isEmpty()) 
                throw new Exception("Fields cannot be empty!");

            books.add(new Book(id, title, author, genre, status));
            System.out.println("Book added!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void viewBooks() {
        if (books.isEmpty()) System.out.println("No books available.");
        else books.forEach(System.out::println);
    }

    static void searchBook() {
        try {
            System.out.print("Enter Book ID or Title: ");
            String input = sc.nextLine().trim();
            books.stream()
                .filter(b -> b.id.equals(input) || b.title.equalsIgnoreCase(input))
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("Book not found."));
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        }
    }

    static void updateBook() {
        try {
            System.out.print("Enter Book ID to update: ");
            String id = sc.nextLine().trim();
            Book book = books.stream().filter(b -> b.id.equals(id)).findFirst().orElse(null);
            if (book == null) throw new Exception("Book not found!");

            System.out.print("Enter new Title: ");
            book.title = sc.nextLine().trim();
            System.out.print("Enter new Author: ");
            book.author = sc.nextLine().trim();
            System.out.print("Enter new Genre: ");
            book.genre = sc.nextLine().trim();
            System.out.print("Enter new Status (Available/Checked Out): ");
            book.status = sc.nextLine().trim();

            System.out.println("Book updated!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void deleteBook() {
        try {
            System.out.print("Enter Book ID to delete: ");
            String id = sc.nextLine().trim();
            if (!books.removeIf(b -> b.id.equals(id))) throw new Exception("Book not found!");
            System.out.println("Book deleted!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static boolean bookExists(String id) {
        return books.stream().anyMatch(b -> b.id.equals(id));
    }
}
