package DesignPatterns.Creational.PrototypeAndRegistry.V0;

public class Client {
    public static void main(String[] args) {
        // 1. Create the registry
        UserPrototypeRegistry registry = new UserPrototypeRegistryImpl();

        // 2. Create prototype objects
        User adminPrototype = new User(1, "admin_user", "admin@example.com", "Admin User", 30, UserType.ADMIN);
        User readerPrototype = new User(2, "reader_user", "reader@example.com", "Reader User", 25, UserType.READER);

        // 3. Add prototypes to the registry
        registry.addPrototype(adminPrototype);
        registry.addPrototype(readerPrototype);

        // 4. Get clones from the registry
        User newAdmin = registry.clone(UserType.ADMIN);
        User newReader = registry.clone(UserType.READER);

        // 5. Verify the cloned objects
        System.out.println("Cloned Admin User: " + newAdmin.getUsername() + ", Type: " + newAdmin.getType());
        System.out.println("Cloned Reader User: " + newReader.getUsername() + ", Type: " + newReader.getType());

        // 6. Verify that the prototype and the clone are different objects in memory
        System.out.println("Is admin prototype the same object as the new admin clone? " + (adminPrototype == newAdmin));
    }
}
