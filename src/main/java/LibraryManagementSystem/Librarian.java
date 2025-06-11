package LibraryManagementSystem;

public class Librarian extends User {
    private String employeeNumber;

    Librarian(String employeeNumber, String name, String contactInfo){
        super(name, contactInfo);
        this.employeeNumber = employeeNumber;
    }

    @Override
    public void displayDashboard() {
        System.out.println("Librarian Dashboard");
        System.out.println("Employee Number : "+ employeeNumber + "Name : " + getName());
        System.out.println("Employee Number: " + employeeNumber);
    }

    @Override
    public boolean canBorrowBooks() {
        return true;
    }

    @Override
    public void returnBook() {
        // // returning a book from the user's perspective.
    }

    public void addNewBook(Book book){

    }

    public  void removeBook(Book book){

    }

}
