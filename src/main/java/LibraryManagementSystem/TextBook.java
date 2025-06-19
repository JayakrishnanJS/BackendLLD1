package LibraryManagementSystem;

public class TextBook extends Book {

    private String subject;
    private int edition;

    public String getSubject() {
        return subject;
    }

    public int getEdition() {
        return edition;
    }

    TextBook(String isbn, String title, String author, BookType type, String subject, int edition) {
        super(isbn, title, author, type);
        this.subject = subject;
        this.edition = edition;
    }

    @Override
    public void displayBookDetails() {
        System.out.println("Subject: " + subject);
        System.out.println("Edition: " + edition);
    }
}
