package IntroToOOP;

public class Student {
    // Attributes/Data/Properties
    String name;
    public int age;
    int studentID;
    EntranceExam exam;
    Batch batch;
    // Composition (“Has-A” Relationship):
    // When a class contains references to other classes as fields, that’s a composition (or “has-a”) relationship.
    // Each Student “has an” EntranceExam and “has a” Batch.

    // Default constructor. Not visible to you directly but present only if there is no custom constructor
    Student(){
        name = "Chirag";
        age = 100;
        studentID = 11;
        exam = new EntranceExam(1, "Test");
    }

//    //Parameterized constructors
//    Student(String name, int age, int studentID){
//        this.name = name;
//        this.age = age;
//        this.studentID = studentID;
//    }

    //Parameterized constructors
    Student(String name, int age){
        this.name = name;
        this.age = age;
        exam = new EntranceExam(1, "Test");
    }

    //Parameterized constructors
    Student(String name1, int age1,  int  studentID1){
        name = name1;
        age = age1;
        studentID = studentID1;
        exam = new EntranceExam(1, "Test");
    }

    //Parameterized constructors
    Student(String name){
        this.name = name;
        age = 0;
        studentID = 0;
        exam = new EntranceExam(1, "Test");
    }

    // copy constructor of Student
    // after making an exact copy in different memory, we can modify necessary attributes which have requires a diff value
    Student(Student other){
        // 1. Direct copy is allowed for primitive and immutable data types
        name = other.name;
        age =  other.age;
        studentID = other.studentID;
        // exam = other.exam;      // Shallow copy -> No new exam object is created, both refer same object.
        // 2. Manual copy with parametrized constructor -> Need to copy each attribute manually
        // exam = new EntranceExam(other.exam.examID, other.exam.examName); // will call parametrized constructor of EntranceExam class
        // 3. Deep Copy with Copy Constructor -> duplicates not only primitive fields but also clones any referenced objects (recursively) so that no mutable state is shared
        exam = new EntranceExam(other.exam); // will call copy constructor of EntranceExam class
        // 4. Shallow copy -> Both the original and the copied object share the same referenced object
        batch = other.batch; // // No new Batch object is created, both share the same reference
    }

    // Constructor to change an attribute of an object after creating its exact copy
    Student(String name, int age, int studentID, EntranceExam exam) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
        this.exam = new EntranceExam(exam); // uses EntranceExam's copy constructor
    }

    Student(String name, int age, int studentID, EntranceExam exam, int batchID) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
        this.exam = new EntranceExam(exam);
        // Because Batch has no int‐arg constructor, do:
        this.batch = new Batch();       // 1) default‐construct
        this.batch.batchID = batchID;   // 2) set the field manually
    }

    // 2-arg constructor calls 5-arg with age = 0, studentID = 0, exam = EntranceExam(0, "NoExam")
    // - `this(...)` call is used to invoke another constructor of the same class.
    // it must always be the first statement in the constructor that contains it.
    // In this case, `this(...)` is delegating the current constructor's responsibility to another constructor that
    // matches the argument structure (`String, int, int, EntranceExam, int`).
    // Each constructor eventually funnels into the 5-parameter constructor, centralizing initialization logic.
    // This prevents forgetting to set exam if you add a new constructor later
    public Student(String name, Batch batch){
        this(name,0,0, new EntranceExam(0, "NoExam"), batch.batchID);

    }

    //Behaviours/Methods/Functions
    void submitAssignment(int assignmentID){
        System.out.println("Completed assignment " + assignmentID);
    }
    void attendingClass(int classID){
        System.out.println("Student "+name+" is attending class " + classID);
    }

    public int getStudentId(){// getter function
        return studentID;
    }

    void setStudentID(int input){// setter function
        studentID = input;
    }
}
