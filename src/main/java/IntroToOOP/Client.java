package IntroToOOP;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hello World !!");

        Student s1 = new Student();
//        s1.name = "Chirag";
//        s1.age = 100;
//        s1.studentID = 1;

        Student s2 = new Student();

        Student s3 = new Student("Jairaj", 120, 101);

        Student s5 = new Student(s1);
//        s1.name = "Deepak";
//
//        Student  s6 = s1;
//        s6.name = "Deepak";
        Student s7 = new Student("Alice", 20, 101, new EntranceExam(1, "JEE"));
        Student s8 = new Student(s7);  // Deep copy

// Modify only the copied object
        s8.name = "Bob";
        s8.exam.examName = "NEET"; // Deep copy ensures s1.exam is unaffected

        System.out.println(s7.name);           // Alice
        System.out.println(s7.exam.examName);  // JEE

        System.out.println(s8.name);           // Bob
        System.out.println(s8.exam.examName);  // NEET

        System.out.println("Hello World !!");

    }
}
