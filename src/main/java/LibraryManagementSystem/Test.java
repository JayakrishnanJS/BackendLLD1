package LibraryManagementSystem;

public class Test {
    public static void main(String[] args) {
//        Testing all constructors - cannot be instantiated once user class is made abstract
//        User user1 = new User();
//        user1.setName("jk");
//        user1.setContactInfo("jk@gmail.com");
//        User user2 = new User("jeeva", "jeeva@gmail.com");
//        User user3 = new User(user2);

//        Testing TextBook class
//        Book tb1 = new TextBook("1231233" , "Ramayan", "Valmiki", "Mythology", 1);
//        tb1.setIsbn("12");

//        Testing NovelBook class
//        Book tb2 = new NovelBook("1231233", "Ramayan", "Valmiki", "Painkili");
//        Casting required to use NovelBook-specific methods
//        if (tb2 instanceof NovelBook) {
//            String genre = ((NovelBook) tb2).getGenre(); // tb2 is unaware of the methods of its parent Book, so casting is required
//            System.out.println(genre);
//        }

        //------------------- Library management system ----------------------------------------------
        // bookInventory and registeredUsers methods are static in LibraryManagementSystem class.
        // This means the inventory of books is shared across all instances of the LibraryManagementSystem
        // => lib1 and lib2 share the same instance for methods in LibraryManagementSystem
        // => ArrayList of `bookInventory` and `registeredUsers` is also shared to
        // Create two library system instances
        LibraryManagementSystem lib1 = new LibraryManagementSystem();
        LibraryManagementSystem lib2 = new LibraryManagementSystem();

        // Add books from lib1
        Book book1 = new TextBook("1" , "Ramayan", "Valmiki",BookType.TEXTBOOK, "Mythology", 1);
        Book book2 = new TextBook("12" , "Balarama", "Luttapi", BookType.TEXTBOOK,"Fun", 2);
        lib1.addBook(book1);
        lib1.addBook(book2);

        // Add a book from lib2
        Book book3 = new NovelBook("123" , "Manorama", "Vanitha", BookType.NOVELBOOK,"Romance");
        Book book4 = new NovelBook("1234" , "Mangalam", "Kaumudy", BookType.NOVELBOOK,"Informative");
        lib2.addBook(book3);

        // Get all books from the shared inventory
        System.out.println("All books in inventory:");
        for (Book book : lib1.getBookInventory()) {
            System.out.println(book.getTitle());
        }
        System.out.println();

        // Register users
        User user1 = new Member("Jeeva", "902929292");
        lib1.registerUser(user1);
        User user2 = new Member("Jk", "9029244442");
        lib2.registerUser(user2);
        User user3 = new Librarian("2456","Shubha", "90233292");
        lib1.registerUser(user3);

        // Get all registered users
        System.out.println("All Registered Users:");
        for (User user : lib1.getRegisteredUsers()) {
            System.out.println(user.getName());
        }
        System.out.println();

        // testing Search functionality
        Book searchedBook1 = lib1.searchBooks( "Ramayan");
        if (searchedBook1 != null) {
            System.out.println("Title: " + searchedBook1.getTitle() + ", Author: " + searchedBook1.getAuthor() + ", Type: " + searchedBook1.getType());
        } else {
            System.out.println("Book not found.");
        }

        Book searchedBook2 =lib1.searchBooks( "Balarama", BookType.NOVELBOOK); // null since Balarama is TEXTBOOK
        if (searchedBook2 != null) {
            System.out.println("Title: " + searchedBook2.getTitle() + ", Author: " + searchedBook2.getAuthor() + ", Type: " + searchedBook2.getType());
        } else {
            System.out.println("Book not found.");
        }

        Book searchedBook3 =lib1.searchBooks( "Balarama", BookType.TEXTBOOK);
        if (searchedBook3 != null) {
            System.out.println("Title: " + searchedBook3.getTitle() + ", Author: " + searchedBook3.getAuthor() + ", Type: " + searchedBook3.getType());
        } else {
            System.out.println("Book not found.");
        }

        Book searchedBook4 =lib1.searchBooks( "Manorama");
        if (searchedBook4 != null) {
            System.out.println("Title: " + searchedBook4.getTitle() + ", Author: " + searchedBook4.getAuthor() + ", Type: " + searchedBook4.getType());
        } else {
            System.out.println("Book not found.");
        }
        System.out.println();

    }
}
