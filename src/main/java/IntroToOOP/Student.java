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

    // Default constructor. Not visible to you directly but present only if there is mo custom constructor
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
        // 1. Direct copy is allowed for primitvie and immutable data types
        name = other.name;
        age =  other.age;
        studentID = other.studentID;
        // exam = other.exam;      // Shallow copy -> No new exam object is created, both refers same object.
        // 2. Manual copy with parametrized constructor -> Need to copy each attribute manually
        // exam = new EntranceExam(other.exam.examID, other.exam.examName); // will call parametrized constructor of EntranceExam class
        // 3. Deep Copy with Copy Constructor -> duplicates not only primitive fields but also clones any referenced objects (recursively) so that no mutable state is shared
        exam = new EntranceExam(other.exam); // will call copy constructor of EntranceExam class
        // 4. Shallow copy -> Both the original and the copied object share the same referenced object
        batch = other.batch; //
    }

    // Constructor to change an attribute of an object after creating it's exact copy
    Student(String name, int age, int studentID, EntranceExam exam) {
        this.name = name;
        this.age = age;
        this.studentID = studentID;
        this.exam = new EntranceExam(exam); // uses EntranceExam's copy constructor
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
