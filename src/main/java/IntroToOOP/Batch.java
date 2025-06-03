package IntroToOOP;

public class Batch {
    int batchID;
    // ← no constructor that takes an int

    //    Student s9 = new Student("Alice", new Batch(2020)); -> This will only compile if Batch has a constructor that takes an int:
    //        public Batch(int batchID) {
    //            this.batchID = batchID;
    //        }
}
