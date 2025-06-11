package LibraryManagementSystem;

public abstract class User {

    private String userId;
    private String name;
    private String contactInfo;
    private static int totalUsers = 0;// attached to class, like a global variable for all the instances of the user and its subclasses

    User() {
        userId = generateUniqueId();
    }

    User(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    User(User anotherUser) {
        this.userId = generateUniqueId();
        this.name = anotherUser.name;
        this.contactInfo = anotherUser.contactInfo;
    }

    private final String generateUniqueId() {// final, such that subclasses cannot override totalusers
        totalUsers++;
        return "User-" + totalUsers;
    }

    private int getTotalUsers(){
        return totalUsers;
    }

    public abstract void displayDashboard();
    public abstract boolean canBorrowBooks();
    public abstract void returnBook();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
