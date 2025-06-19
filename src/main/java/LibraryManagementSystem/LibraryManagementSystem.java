package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class LibraryManagementSystem {
    private static List<Book> bookInventory;
    private static List<User> registeredUsers;

    public LibraryManagementSystem(){
        bookInventory = new ArrayList<>();
        registeredUsers = new ArrayList<>();
    }
    public List<Book> getBookInventory() {
        return bookInventory;
    }

    public void setBookInventory(List<Book> bookInventory) {
        this.bookInventory = bookInventory;
    }

    public List<User> getRegisteredUsers() {
        return registeredUsers;
    }

    public void setRegisteredUsers(List<User> registeredUsers) {
        this.registeredUsers = registeredUsers;
    }

    public void addBook(Book book){
        bookInventory.add(book);
    }

    public void registerUser(User user){
        registeredUsers.add(user);
    }

    public static Book searchBooks(String criteria){
        for(Book book : bookInventory){
            if(book.getAuthor().equalsIgnoreCase(criteria) ||
                    book.getTitle().equalsIgnoreCase(criteria) ){
                return book;
            }
        }
        return null;
    }

    public static Book searchBooks(String criteria , BookType type){
        for(Book book : bookInventory){
            if((book.getAuthor().equalsIgnoreCase(criteria) ||
                    book.getTitle().equalsIgnoreCase(criteria))
                    && book.getType() == type ){
                return book;
            }
        }
        return null;
    }
}
