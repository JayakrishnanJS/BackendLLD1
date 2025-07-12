package DesignPatterns.PrototypeAndRegistry;

public class StudentUtility {
    // StudentUtility client is not concerned about which object is coming
    // purpose: decoupling and reuse of the “make a copy and do something with it” logic so that our client code
    // doesn’t have to duplicate it every time.
//    public static void createCopy(Student student) {
//        Student s1 = student.copy();
//        System.out.println(s1.getName());
//    }
    public static <T extends Student> T createCopy(T proto) {
        System.out.println("proto.getName() = " + proto.getName());
        System.out.println("proto.getPsp() = " + proto.getPsp());
        return (T) proto.copy(); // T can be Student or suntype of Student. Casting guarantee that this Student is of Type T
    }
}
/*

Utility classes act as helpers or service for other code components and are not designed to represent core features or
behaviors in a program. Mostly static

 1. Centralizing common behavior
      a. Single Place to Change: If you later decide that every copy should be logged, or validated,
                         or enriched before you print the name, you only change it in one spot.
      b. Reduced Duplication: Your client doesn’t have to do copy() + println() twice
                              (once for Student, once for IntelligentStudent).
      c. Type-Agnostic: Because it accepts the base type, it works for any subtype that implements Prototype<Student>
 2. Decoupling clients from concrete actions
      without utility client main looks like
                    Student stCopy = st.copy();
                    System.out.println(stCopy.getName());

                    IntelligentStudent isCopy = is.copy();
                    System.out.println(isCopy.getName());
       By extracting to StudentUtility.createCopy(...), you ensure that all clients do the
       copy → process → print workflow the same way.
*/