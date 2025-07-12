package DesignPatterns.PrototypeAndRegistry;

public class Client {

    public static void main(String[] args) {
        //Student st = new Student(1 , "Mohit" , 26,"DSML");
        // 1. Copying reference
        // Student st1 = new Student();
        // Student st1 = st;
        // Student st2 = st;
        // Pblm: copies reference of st and store it in new object st2. Doesn't copy the object
        // 2. Using setters to create copy
        // Student st2 = new Student();
        // st1.attr1 = st.attr1;
        // st1.attr2 = st.attr2;
        // Pblms:
        // 1. Not reusable
        // 2. Not maintainable and extensible
        // 3. Some may be Private attributes and don't have setters
        // 4. Burden for Client to take care of everything
        // all these pblms => we want the class to take care of the responsibility of copying, not making the client do it.
        // Copy constructor can be used to solve all these pblms
        // But if the class has a subclass(inheritance), we need to use interface and declare a copy method and override it in
        // student class and Intelligent student class.
        // then we can use run time polymorphism to create a particular copy method - either student or intelligent student

        // 1) Original student
        Student student = new Student(2012, 1, "Mohit", 80);
        Student stClone = student.copy();
        System.out.println("stClone.getName() = " + stClone.getName());   // Mohit
        System.out.println("stClone.getPSP() = " + stClone.getPsp()); // 80

        // 2) Prototype for intelligent student
        IntelligentStudent isProto = new IntelligentStudent();
        isProto.setId(2);
        isProto.setName("Einstein");
        isProto.setGradYear(1919);
        isProto.setPsp(100);
        isProto.setIq(150);

        // 3) Copy the initialized prototype
        IntelligentStudent isClone = isProto.copy();
        System.out.println("isClone.getName() = " + isClone.getName());   // Einstein
        System.out.println("isClone.getIq()   = " + isClone.getIq());     // 150

        // 4) If you want to mutate the clone:
        IntelligentStudent isModified = isProto.copy();
        isModified.setIq(200);
        System.out.println("isModified.getIq() = " + isModified.getIq()); // 200


        // to reduce client from creating objects and take care of run time polymorphism(copy()), utility
        Student isClone2 = StudentUtility.createCopy(student); // passing student
        // if i want to change some attribute in new copied object
        isClone2.setName("JK");
        System.out.println("isClone.getName() = " + isClone.getName());
        Student isClone3 = StudentUtility.createCopy(isProto); // passing intelligent student
        isClone3.setPsp(99);
        System.out.println("isClone3.getBatch() = " + isClone3.getPsp());


        System.out.println("--------------REGISTRY--------------");

        // 1) Create & populate one registry for all type of students
        // Initialize once in the client. If we want lazy initialization, make TemplateInitializer to return this instance as in double-checked locking
        new StudentTemplateInitializer().initializeTemplates();
        StudentRegistry registry = StudentRegistry.INSTANCE;

        // 2) Copy a plain DEVOPS student
        Student devopsStudentClone = registry.get(StudentType.DEVOPS);
        devopsStudentClone.setName("Copied Generic DEVOPS Student");
        System.out.println("DEVOPS Copy: " + devopsStudentClone.getName());

        // 3) Clone and customize SOFTWARE (IntelligentStudent)
        Student softwareStudentTemplate = registry.get(StudentType.SOFTWARE);
        IntelligentStudent intelligentSoftwareStudentClone = new IntelligentStudent(softwareStudentTemplate);
        intelligentSoftwareStudentClone.setIq(150);
        intelligentSoftwareStudentClone.setName("Copied Intelligent SOFTWARE Student");
        System.out.println("SOFTWARE Copy: " + intelligentSoftwareStudentClone.getName() +
                " (IQ=" + intelligentSoftwareStudentClone.getIq() + ")");
        System.out.println(registry.getRegisteredCount());
        System.out.println("---- Test Completed ----");
    }
}

/*
The prototype pattern is a creational design pattern that can be used to create
objects that are similar to each other. The pattern is used to avoid the cost of creating
new objects by cloning an existing object and avoiding dependencies on the class of
the object that needs to be cloned.

Prototype allows us to hide the complexity of making new instances from the client.
The concept is to copy an existing object rather than creating a new instance from
scratch, something that may include costly operations. The existing object acts as a
prototype and contains the state of the object. The newly copied object may change
same properties only if required. This approach saves costly resources and time,
especially when object creation is a heavy process.

Prototype Registry:
The prototype pattern can be extended to use a registry of pre-defined prototypes. The
registry can be used to store a set of pre-defined prototypes. The client code can then
request a clone of a prototype from the registry instead of creating a new object from
scratch. The registry can be implemented as a key-value store where the key is the name
of the prototype and the value is the prototype object.
*/