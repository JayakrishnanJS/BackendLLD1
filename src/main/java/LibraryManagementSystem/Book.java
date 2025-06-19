
package LibraryManagementSystem;

public abstract class Book implements Lendable{
    private String isbn;
    private String title;
    private String author;
    private boolean isAvailable;
    private final BookType type;

    Book(BookType type){
        this.type = type;
        isAvailable = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    Book(String isbn, String title, String author, BookType type) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.type = type;
        this.isAvailable = true; // initially book is available
    }

    @Override
    public boolean lend(User user) {
        if (isAvailable && user.canBorrowBooks()) {
            isAvailable = false;
        }
        return false;
    }

    @Override
    public void returnBook(User user) { // Manages the state of the book itself during the return process.
        isAvailable = true;
        user.returnBook(); // initiate a return
        // returnBook method in User and Book class are different.
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    public abstract void displayBookDetails();

    public BookType getType() {
        return type;
    }
}
