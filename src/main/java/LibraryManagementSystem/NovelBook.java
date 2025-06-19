package LibraryManagementSystem;

public class NovelBook extends Book {
    private String genre;

    NovelBook(String isbn, String title, String author, BookType type, String genre) {
        super(isbn, title, author, type);
        this.genre = genre;
    }

    @Override
    public void displayBookDetails() {
        System.out.println("Genre: " + genre);
    }

    public String getGenre() {
        return genre;
    }
}
// we intend the `genre` to be immutable(unchangeable) after the object is created
// => no setters are required